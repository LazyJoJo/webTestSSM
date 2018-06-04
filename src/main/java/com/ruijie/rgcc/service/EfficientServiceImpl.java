package com.ruijie.rgcc.service;

import com.ruijie.rgcc.entity.CafCodeInfo;
import com.ruijie.rgcc.entity.Qualification;
import com.ruijie.rgcc.entity.ResMngRecordInfo;
import com.ruijie.rgcc.entity.SvnMessage;
import com.ruijie.rgcc.entity.EasyuiResult;
import com.ruijie.rgcc.inter.EfficientService;
import com.ruijie.rgcc.service.dao.EfficientServiceDao;
import com.ruijie.rgcc.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * <p>Title:                            </p>
 * <p>Description:                      </p>
 * <p>Copyright: Copyright (c) 2018     </p>
 * <p>Company: Ruijie Co., Ltd.         </p>
 * <p>Create Time:    2018/6/4          </p>
 *
 * @author zhengchengbin
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
@Service
public class EfficientServiceImpl implements EfficientService {
    /**
     *  EfficientService Dao
     */
    @Resource
    private EfficientServiceDao efficientServiceDao;
    /**
     * 日志对象
     */
    private static Logger logger = Logger.getLogger(EfficientServiceImpl.class);

    /**
     * <p>Description: 返回所有的资质信息</p>
     * <p>Create Time: 2018/6/4 </p>
     * @author zhengchengbin
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    public List<Qualification> getAll() {
        return efficientServiceDao.getAllQualification();
    }

    /**
     * <p>Description: 获取用户基本信息（包含用户名，研究组，研究部门）</p>
     * <p>Create Time: 2018/6/4 </p>
     * @author zhengchengbin
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.ResMngRecordInfo>
     * @throws
     */
    public List<ResMngRecordInfo> findUserGroupDeptInfo() {
        return efficientServiceDao.findUserGroupDeptInfo();
    }


    /**
     * <p>Description: 根据不同的查询条件获取代码统计量</p>
     * <p>Create Time: 2018/6/6 </p>
     * @author zhengchengbin
     * @param queryType, resMngRecordInfo
     * @return java.util.List<net.sf.json.JSONObject>
     * @throws
     */
    public List<JSONObject> getCodeLineInfo(String queryType, ResMngRecordInfo resMngRecordInfo) {
        List<CafCodeInfo> cafCodeInfos = new ArrayList<CafCodeInfo>();
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        String timeStart = resMngRecordInfo.getResWeekStartDate();
        String timeEnd = resMngRecordInfo.getResWeekEndDate();
        cafCodeInfos = efficientServiceDao.getCodeInfoByTime(timeStart, timeEnd);

        if (queryType.equalsIgnoreCase("pkg")) {
            jsonObjects = this.getCodeLineInfoByPkg(cafCodeInfos, resMngRecordInfo);
        } else if (queryType.equalsIgnoreCase("group")) {
            jsonObjects = this.getCodeLineInfoByPkg(cafCodeInfos, resMngRecordInfo);
            jsonObjects = this.getDeptCodeLineInfoByGroup(jsonObjects);
        } else if (queryType.equalsIgnoreCase("dept")) {
            jsonObjects = this.getCodeLineInfoByPkg(cafCodeInfos, resMngRecordInfo);
            jsonObjects = this.getDeptCodeLineInfoByGroup(jsonObjects);
            jsonObjects = this.getDeptCodeLineInfoByDept(jsonObjects);
        }
        return jsonObjects;
    }

    /**
     * <p>Description: 根据组件包信息获取代码统计信息</p>
     * <p>Create Time: 2018/6/6 </p>
     * @author zhengchengbin
     * @param cafCodeInfos, resMngRecordInfo
     * @return java.util.List<net.sf.json.JSONObject>
     * @throws
     */
    public List<JSONObject> getCodeLineInfoByPkg(List<CafCodeInfo> cafCodeInfos, ResMngRecordInfo resMngRecordInfo) {
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        Set<String> pkgs = new HashSet<String>();
        for (CafCodeInfo cafCodeInfo : cafCodeInfos) {
            pkgs.add(cafCodeInfo.getPkg());
        }
        for (String pkg : pkgs) {
            String pkgName = pkg.toUpperCase();
            int totalAddCodeLine = 0;
            int totalDelCodeLine = 0;
            int totalCodeLine = 0;
            int[] monthAddData = new int[12];
            int[] monthDelData = new int[12];
            int[] monthTotalData = new int[12];
            for (int i = 0; i < 12; i++) {
                monthAddData[i] = 0;
                monthDelData[i] = 0;
                monthTotalData[i] = 0;
            }
            for (CafCodeInfo cafCodeInfo : cafCodeInfos) {
                String pkgNameTmp = cafCodeInfo.getPkg().toUpperCase();
                //组件包过滤
                if (pkgName.length() > 0) {
                    if (cafCodeInfo.getPkg() == null || cafCodeInfo.getPkg() == "" || pkgName.indexOf(pkgNameTmp) == -1) {
                        continue;
                    }
                }
                int addCodeLine = Integer.valueOf(cafCodeInfo.getAddcodeline()).intValue();
                int delCodeLine = Integer.valueOf(cafCodeInfo.getDelcodeline()).intValue();
                String applyTime = cafCodeInfo.getDate();
                if (addCodeLine > 5000 || delCodeLine > 5000) {
                    continue;
                }
                for (int i = 0; i < 12; i++) {
                    String timeStart = resMngRecordInfo.getResWeekStartDate();
                    String timeEnd = resMngRecordInfo.getResWeekEndDate();
                    if (Tools.timeCompare(applyTime, timeStart, timeEnd)) {
                        monthAddData[i] += addCodeLine;
                        monthDelData[i] += delCodeLine;
                        monthTotalData[i] = (monthAddData[i] - monthDelData[i]);
                    }
                }
                totalAddCodeLine += addCodeLine;
                totalDelCodeLine += delCodeLine;
            }
            totalCodeLine = totalAddCodeLine - totalDelCodeLine;
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("pkgname", pkgName);
            jsonobject.put("codenum", totalCodeLine);
            jsonobject.put("addcodenum", totalAddCodeLine);
            jsonobject.put("delcodenum", totalDelCodeLine);
            for (int i = 0; i < 12; i++) {
                String monthName = "monthtotal" + (i + 1);
                jsonobject.put(monthName, monthTotalData[i]);
            }
            jsonObjects.add(jsonobject);
        }
        return jsonObjects;
    }

    /**
     * <p>Description: 根据小组信息统计用户代码量</p>
     * <p>Create Time: 2018/6/6 </p>
     * @author zhengchengbin
     * @param jsonObjects
     * @return java.util.List<net.sf.json.JSONObject>
     * @throws
     */
    public List<JSONObject> getDeptCodeLineInfoByGroup(List<JSONObject> jsonObjects) {
        List<JSONObject> groupJsonObjects = new ArrayList<JSONObject>();
        String[] GroupList = {"管理专业组", "品质专业组", "系统专业1组", "系统专业2组", "认证专业组", "二层组", "安全专业组",
                "应用专业组", "三层专业组", "出口专业组", "DC专业组", "IGP专业组", "EGP专业组", "MCAST专业组", "MPLS专业组"};
        String GroupPkgMap = "{\"管理专业组\":\"mng#oam\",\"品质专业组\":\"dev#ras\",\"系统专业1组\":\"bsp\"," +
                "\"系统专业2组\":\"utils\",\"认证专业组\":\"security\",\"二层组\":\"lsm#bridge\"," +
                "\"安全专业组\":\"fw#ipfix#net_def\",\"应用专业组\":\"app\",\"三层专业组\":\"ip#net\"," +
                "\"出口专业组\":\"vpn#UnifyManage#sslvpn\",\"DC专业组\":\"dc\",\"IGP专业组\":\"libpub\"," +
                "\"EGP专业组\":\"ucast \",\"MCAST专业组\":\"MCAST#openflow\",\"MPLS专业组\":\"MPLS\"}";
        JSONObject GroupPkgJson = JSONObject.fromObject(GroupPkgMap);
        for (String groupName : GroupList) {
            int groupCodeLine = 0;
            int[] groupMonthTotalData = new int[12];
            for (int i = 0; i < 12; i++) {
                groupMonthTotalData[i] = 0;
            }
            String[] groupPkgTmp = GroupPkgJson.getString(groupName).split("#");
            for (JSONObject jsonObject : jsonObjects) {
                String pkgName = jsonObject.getString("pkgname").toUpperCase();
                for (String pkgNameTmp : groupPkgTmp) {
                    if (pkgName.equals(pkgNameTmp.toUpperCase())) {
                        String codeLineNum = jsonObject.getString("codenum");
                        groupCodeLine += Integer.valueOf(codeLineNum).intValue();
                        for (int i = 0; i < 12; i++) {
                            String monthName = "monthtotal" + (i + 1);
                            groupMonthTotalData[i] += Integer.valueOf(jsonObject.getString(monthName)).intValue();
                        }
                    }
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("pkgname", groupName);
            jsonObject.put("codenum", groupCodeLine);
            for (int i = 0; i < 12; i++) {
                String monthName = "monthtotal" + (i + 1);
                jsonObject.put(monthName, groupMonthTotalData[i]);
            }
            groupJsonObjects.add(jsonObject);
        }
        return groupJsonObjects;
    }

    /**
     * <p>Description: 根据部门信息统计用户代码量</p>
     * <p>Create Time: 2018/6/7 </p>
     * @author zhengchengbin
     * @param jsonObjects
     * @return java.util.List<net.sf.json.JSONObject>
     * @throws
     */
    public List<JSONObject> getDeptCodeLineInfoByDept(List<JSONObject> jsonObjects) {

        List<JSONObject> deptJsonObjects = new ArrayList<JSONObject>();
        String[] deptList = {"平台一部", "平台四部", "平台五部", "平台六部"};
        String groupPkgMap = "{\"平台一部\":\"管理专业组#品质专业组#系统专业1组#系统专业2组\",\"平台四部\":\"认证专业组#二层组#安全专业组\",\"平台五部\":\"应用专业组#三层专业组#出口专业组\",\"平台六部\":\"DC专业组#IGP专业组#EGP专业组#MCAST专业组#MPLS专业组\"}";
        JSONObject groupPkgJson = JSONObject.fromObject(groupPkgMap);
        for (String groupName : deptList) {
            int groupCodeLine = 0;
            int[] groupMonthTotalData = new int[12];
            for (int i = 0; i < 12; i++) {
                groupMonthTotalData[i] = 0;
            }
            String[] groupPkgTmp = groupPkgJson.getString(groupName).split("#");
            for (JSONObject jsonObject : jsonObjects) {
                String pkgName = jsonObject.getString("pkgname");
                for (String pkgNameTmp : groupPkgTmp) {
                    if (pkgName.equals(pkgNameTmp)) {
                        String codeLineNum = jsonObject.getString("codenum");
                        groupCodeLine += Integer.valueOf(codeLineNum).intValue();
                        for (int i = 0; i < 12; i++) {
                            String monthName = "monthtotal" + (i + 1);
                            groupMonthTotalData[i] += Integer.valueOf(jsonObject.getString(monthName)).intValue();
                        }
                    }
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("pkgname", groupName);
            jsonObject.put("codenum", groupCodeLine);
            for (int i = 0; i < 12; i++) {
                String monthName = "monthtotal" + (i + 1);
                jsonObject.put(monthName, groupMonthTotalData[i]);
            }
            deptJsonObjects.add(jsonObject);
        }
        return deptJsonObjects;
    }

    /**
     * <p>Description: 根据条件获取svn数据表信息</p>
     * <p>Create Time: 2018/6/7 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd, type
     * @return java.util.List<com.ruijie.rgcc.entity.SvnMessage>
     * @throws
     */
    public List<SvnMessage> getCodeLineBySvn(String timeStart, String timeEnd, String type) {
        List<SvnMessage> svnMessages = new ArrayList<SvnMessage>();
        if (type == "") {
            svnMessages = efficientServiceDao.getCodeLineBySvn(timeStart, timeEnd);
        }
        return svnMessages;
    }

    /**
     * <p>Description: 按项目获取在指定时间区间内的用户信息</p>
     * <p>Create Time: 2018/6/7 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd, project
     * @return java.util.List<com.ruijie.rgcc.entity.CafCodeInfo>
     * @throws
     */
    public List<CafCodeInfo> getEachPersonByProject(String timeStart, String timeEnd, String project) {
        List<CafCodeInfo> cafCodeInfos = new ArrayList<CafCodeInfo>();
        List<CafCodeInfo> cafCodeInfoTmps = new ArrayList<CafCodeInfo>();
        List<CafCodeInfo> cafCodeInfoAnss = new ArrayList<CafCodeInfo>();
        List<String> nameList = getPersonName(timeStart, timeEnd, project);
        cafCodeInfos = efficientServiceDao.getCodeInfoByTime(timeStart, timeEnd);
        for (String name : nameList) {
            for (CafCodeInfo cafCodeInfo : cafCodeInfos) {
                if (cafCodeInfo.getUsername().equalsIgnoreCase(name)) {
                    cafCodeInfoTmps.add(cafCodeInfo);
                }
            }
            int codeNum = 0;
            int addCodeLineSum = 0;
            int delCodeLineSum = 0;
            CafCodeInfo cafCodeInfoAns = new CafCodeInfo();
            for (CafCodeInfo cafCodeInfo : cafCodeInfoTmps) {
                int addCodeLine = Integer.valueOf(cafCodeInfo.getAddcodeline());
                int delCodeLine = Integer.valueOf(cafCodeInfo.getDelcodeline());
                codeNum = codeNum + addCodeLine - delCodeLine;
                addCodeLineSum += addCodeLine;
                delCodeLineSum += delCodeLine;
            }
            codeNum = codeNum > 0 ? codeNum : 0;
            addCodeLineSum = addCodeLineSum > 0 ? addCodeLineSum : 0;
            delCodeLineSum = delCodeLineSum > 0 ? delCodeLineSum : 0;
            cafCodeInfoAns.setCodelines(String.valueOf(codeNum));
            cafCodeInfoAns.setAddcodeline(String.valueOf(addCodeLineSum));
            cafCodeInfoAns.setDelcodeline(String.valueOf(delCodeLineSum));
            cafCodeInfoAns.setUsername(name);
            cafCodeInfoAnss.add(cafCodeInfoAns);
        }
        return cafCodeInfoAnss;
    }

    /**
     * <p>Description: 按项目获取在指定时间内的用户名信息</p>
     * <p>Create Time: 2018/6/4 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd, project
     * @return java.util.List<java.lang.String>
     * @throws
     */
    public List<String> getPersonName(String timeStart, String timeEnd, String project) {
        List<String> names = new ArrayList<String>();
        names = efficientServiceDao.getPersonNameByProject(timeStart, timeEnd, project);
        return names;
    }

    /**
     * <p>Description: 根据查询信息获取资质信息并返回给table列表</p>
     * <p>Create Time: 2018/6/8 </p>
     * @author zhengchengbin
     * @param dept, group, username, type, pageSize, pageNum
     * @return com.ruijie.rgcc.entity.EasyuiResult
     * @throws
     */
    public EasyuiResult getQualification(String dept, String group, String userName, String type,
                                         int pageSize, int pageNum) {

        List<Qualification> qualifications = new ArrayList<Qualification>();
        List<Qualification> subQualifications ;
        EasyuiResult easyuiResult = new EasyuiResult();

        if (type.equals("dept")) {
            qualifications = efficientServiceDao.getQualificationByDept(dept);
        } else if (type.equals("group")) {
            qualifications = efficientServiceDao.getQualificationByGroup(dept, group);
        } else if (type.equals("user")) {
            qualifications = efficientServiceDao.getQualificationByUserName(dept, group, userName);
        } else if (type.equals("all")) {
            qualifications = efficientServiceDao.getAllQualification();
        } else {
            logger.error("don't catch qualification type");
        }

        if (!type.equals("user")) {
            int first = (pageNum - 1) * pageSize;
            int end = (pageNum) * pageSize < qualifications.size() ? (pageNum) * pageSize : qualifications.size();
            subQualifications = qualifications.subList(first, end);
        } else {
            subQualifications = qualifications;
        }

        easyuiResult.setTotal(qualifications.size());
        easyuiResult.setRows(subQualifications);
        return easyuiResult;
    }

    /**
     * <p>Description: 更新资质信息</p>
     * <p>Create Time: 2018/6/4 </p>
     * @author zhengchengbin
     * @param qualification
     * @return java.lang.String
     * @throws
     */
    public String updateQualification(Qualification qualification) {
        boolean message = efficientServiceDao.updateQualification(qualification);
        if (message) {
            return "success";
        }
        return "error";
    }

}

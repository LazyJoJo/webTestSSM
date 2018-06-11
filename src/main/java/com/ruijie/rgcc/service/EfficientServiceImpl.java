package com.ruijie.rgcc.service;

import com.ruijie.rgcc.entity.CafCodeInfo;
import com.ruijie.rgcc.entity.Qualification;
import com.ruijie.rgcc.entity.ResMngRecordInfo;
import com.ruijie.rgcc.entity.SvnMessage;
import com.ruijie.rgcc.entity.EasyuiResult;
import com.ruijie.rgcc.entity.DepartmentEnum;
import com.ruijie.rgcc.entity.GroupEnum;
import com.ruijie.rgcc.entity.ClassifyEnum;
import com.ruijie.rgcc.inter.EfficientService;
import com.ruijie.rgcc.service.dao.EfficientServiceDao;
import com.ruijie.rgcc.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * enum
     */
    @Resource
    private ClassifyEnum classifyEnum;

    @Resource
    private GroupEnum groupEnum ;

    @Resource
    private DepartmentEnum departmentEnum ;

    /**
     * 日志对象
     */
    private static Logger logger = Logger.getLogger(EfficientServiceImpl.class);

    /**
     *  月份常量
     */
    private static final int MONTH = 12;

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
        if (queryType.equalsIgnoreCase(classifyEnum.PACKAGE.getName())) {
            jsonObjects = this.getCodeLineInfoByPkg(cafCodeInfos, resMngRecordInfo);
        } else if (queryType.equalsIgnoreCase(classifyEnum.GROUP.getName())) {
            jsonObjects = this.getCodeLineInfoByPkg(cafCodeInfos, resMngRecordInfo);
            jsonObjects = this.getDeptCodeLineInfoByGroup(jsonObjects);
        } else if (queryType.equalsIgnoreCase(classifyEnum.DEPARTMENT.getName())) {
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
            int[] monthAddData = new int[MONTH];
            int[] monthDelData = new int[MONTH];
            int[] monthTotalData = new int[MONTH];
            for (int i = 0; i < MONTH; i++) {
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
                for (int i = 0; i < MONTH; i++) {
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
        List<String> groups = new ArrayList<String>();
        Map<String, String> groupPkgMap = new HashMap<String, String>();
        for (GroupEnum group: groupEnum.values()){
            groups.add(group.getKey());
            groupPkgMap.put(group.getKey(),group.getValue());
        }
        JSONObject GroupPkgJson = JSONObject.fromObject(groupPkgMap);
        for (String groupName : groups) {
            int groupCodeLine = 0;
            int[] groupMonthTotalData = new int[MONTH];
            for (int i = 0; i < MONTH; i++) {
                groupMonthTotalData[i] = 0;
            }
            String[] groupPkgTmp = GroupPkgJson.getString(groupName).split("#");
            for (JSONObject jsonObject : jsonObjects) {
                String pkgName = jsonObject.getString("pkgname").toUpperCase();
                for (String pkgNameTmp : groupPkgTmp) {
                    if (pkgName.equals(pkgNameTmp.toUpperCase())) {
                        String codeLineNum = jsonObject.getString("codenum");
                        groupCodeLine += Integer.valueOf(codeLineNum).intValue();
                        for (int i = 0; i < MONTH; i++) {
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
        List<String> departments = new ArrayList<String>();
        Map<String,String> departmentPkgMap = new HashMap<String, String>();
        for(DepartmentEnum department : departmentEnum.values()){
            departments.add(department.getKey());
            departmentPkgMap.put(department.getKey(),department.getValue());
        }
        JSONObject groupPkgJson = JSONObject.fromObject(departmentPkgMap);
        for (String groupName : departments) {
            int groupCodeLine = 0;
            int[] groupMonthTotalData = new int[MONTH];
            for (int i = 0; i < MONTH; i++) {
                groupMonthTotalData[i] = 0;
            }
            String[] groupPkgTmp = groupPkgJson.getString(groupName).split("#");
            for (JSONObject jsonObject : jsonObjects) {
                String pkgName = jsonObject.getString("pkgname");
                for (String pkgNameTmp : groupPkgTmp) {
                    if (pkgName.equals(pkgNameTmp)) {
                        String codeLineNum = jsonObject.getString("codenum");
                        groupCodeLine += Integer.valueOf(codeLineNum).intValue();
                        for (int i = 0; i < MONTH; i++) {
                            String monthName = "monthtotal" + (i + 1);
                            groupMonthTotalData[i] += Integer.valueOf(jsonObject.getString(monthName)).intValue();
                        }
                    }
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("pkgname", groupName);
            jsonObject.put("codenum", groupCodeLine);
            for (int i = 0; i < MONTH; i++) {
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
            return "update success";
        }
        return "update error";
    }

}

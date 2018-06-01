package com.ruijie.rgcc.service;

import com.ruijie.rgcc.entity.*;
import com.ruijie.rgcc.inter.EfficientService;
import com.ruijie.rgcc.service.dao.EfficientServiceDao;
import com.ruijie.rgcc.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>Title:                            </p>
 * <p>Description:                      </p>
 * <p>Copyright: Copyright (c) 2018     </p>
 * <p>Company: Ruijie Co., Ltd.         </p>
 * <p>Create Time:    2018/5/28         </p>
 *
 * @author zhengchengbin
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
@Service
public class EfficientServiceImpl implements EfficientService {
    @Resource
    private EfficientServiceDao efficientServiceDao;
    private static Logger logger = Logger.getLogger(EfficientServiceImpl.class);


    /**
     * <p>Description: </p>
     * <p>Create Time: 2018/5/29 </p>
     *
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     * @author zhengchengbin
     */
    public List<Qualification> getAll() {
        return efficientServiceDao.findAll();
    }

    /**
     * <p>Description: </p>
     * <p>Create Time: 2018/5/29 </p>
     *
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.ResMngRecordInfo>
     * @throws
     * @author zhengchengbin
     */
    //summary
    public List<ResMngRecordInfo> findUserGroupDeptInfo() {
        return efficientServiceDao.findUserGroupDeptInfo();
    }

    /**
     * <p>Description: </p>
     * <p>Create Time: 2018/5/30 </p>
     *
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.ResMngRecordInfo>
     * @throws
     * @author zhengchengbin
     */
    //summary
    public List<ResMngRecordInfo> getPatformResRecord() {
        return efficientServiceDao.getPatformResRecord();
    }

    /**
     * <p>Description: </p>
     * <p>Create Time: 2018/5/31 </p>
     *
     * @param
     * @return java.util.List<net.sf.json.JSONObject>
     * @throws
     * @author zhengchengbin
     */
    public List<JSONObject> getCodeLineInfo(String querytype, ResMngRecordInfo resMngRecordInfo) {

        List<CafCodeInfo> cafCodeList = new ArrayList<CafCodeInfo>();
        List<JSONObject> jsonList = new ArrayList<JSONObject>();
        String timeS = resMngRecordInfo.getRes_week_start_date();
        String timeE = resMngRecordInfo.getRes_week_end_date();
        cafCodeList = efficientServiceDao.getCodeInfoByTime(timeS, timeE);

        if (querytype.equalsIgnoreCase("pkg")) {
            jsonList = this.getCodeLineInfoByPkg(cafCodeList, resMngRecordInfo);
        } else if (querytype.equalsIgnoreCase("group")) {
            jsonList = this.getCodeLineInfoByPkg(cafCodeList, resMngRecordInfo);
            jsonList = this.getDeptCodeLineInfoByGroup(jsonList);
        } else if (querytype.equalsIgnoreCase("dept")) {
            jsonList = this.getCodeLineInfoByPkg(cafCodeList, resMngRecordInfo);
            jsonList = this.getDeptCodeLineInfoByGroup(jsonList);
            jsonList = this.getDeptCodeLineInfoByDept(jsonList);
        }
        return jsonList;
    }

    public List<JSONObject> getCodeLineInfoByPkg(List<CafCodeInfo> cafCodeList, ResMngRecordInfo resMngRecordInfo) {

        List<JSONObject> jsonList = new ArrayList<JSONObject>();
        Set<String> pkgSet = new HashSet<String>();
        for (CafCodeInfo cafCodeInfo : cafCodeList) {
            pkgSet.add(cafCodeInfo.getPkg());
        }
        for (String pkg : pkgSet) {
            String pkgname = pkg.toUpperCase();
            int totaladdcodeline = 0;
            int totaldelcodeline = 0;
            int totalcodeline = 0;
            int[] monthadddata = new int[12];
            int[] monthdeldata = new int[12];
            int[] monthtotaldata = new int[12];
            for (int i = 0; i < 12; i++) {
                monthadddata[i] = 0;
                monthdeldata[i] = 0;
                monthtotaldata[i] = 0;
            }
            for (CafCodeInfo cafCodeInfo : cafCodeList) {
                String pkgnametmp = cafCodeInfo.getPkg().toUpperCase();
                //组件包
                if (pkgname.length() > 0) {
                    if (cafCodeInfo.getPkg() == null || cafCodeInfo.getPkg() == "" || pkgname.indexOf(pkgnametmp) == -1) {
                        continue;
                    }
                }
                int addcodeline = Integer.valueOf(cafCodeInfo.getAddcodeline()).intValue();
                int delcodeline = Integer.valueOf(cafCodeInfo.getDelcodeline()).intValue();
                String applytime = cafCodeInfo.getDate();
                if (addcodeline > 5000 || delcodeline > 5000) {
                    continue;
                }
                for (int i = 0; i < 12; i++) {
                    String timeS = resMngRecordInfo.getRes_week_start_date();
                    String timeE = resMngRecordInfo.getRes_week_end_date();
                    if (Tools.timeCompare(applytime, timeS, timeE)) {
                        monthadddata[i] += addcodeline;
                        monthdeldata[i] += addcodeline;
                        monthtotaldata[i] = (monthadddata[i] - monthdeldata[i]);
                        //break;
                    }
                }
                totaladdcodeline += addcodeline;
                totaldelcodeline += delcodeline;
            }
            totalcodeline = totaladdcodeline - totaldelcodeline;
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("pkgname", pkgname);
            jsonobject.put("codenum", totalcodeline);
            jsonobject.put("addcodenum", totaladdcodeline);
            jsonobject.put("delcodenum", totaldelcodeline);
            for (int i = 0; i < 12; i++) {
                String monthname = "monthtotal" + (i + 1);
                jsonobject.put(monthname, monthtotaldata[i]);
            }
            jsonList.add(jsonobject);
        }
        return jsonList;
    }

    public List<JSONObject> getDeptCodeLineInfoByGroup(List<JSONObject> jsonList) {
        List<JSONObject> groupjsonList = new ArrayList<JSONObject>();

        String[] Grouplist = {"管理专业组", "品质专业组", "系统专业1组", "系统专业2组", "认证专业组", "二层组", "安全专业组",
                "应用专业组", "三层专业组", "出口专业组", "DC专业组", "IGP专业组", "EGP专业组", "MCAST专业组", "MPLS专业组"};
        String GroupPkgMap = "{\"管理专业组\":\"mng#oam\",\"品质专业组\":\"dev#ras\",\"系统专业1组\":\"bsp\"," +
                "\"系统专业2组\":\"utils\",\"认证专业组\":\"security\",\"二层组\":\"lsm#bridge\"," +
                "\"安全专业组\":\"fw#ipfix#net_def\",\"应用专业组\":\"app\",\"三层专业组\":\"ip#net\"," +
                "\"出口专业组\":\"vpn#UnifyManage#sslvpn\",\"DC专业组\":\"dc\",\"IGP专业组\":\"libpub\"," +
                "\"EGP专业组\":\"ucast \",\"MCAST专业组\":\"MCAST#openflow\",\"MPLS专业组\":\"MPLS\"}";
        JSONObject GroupPkgjson = JSONObject.fromObject(GroupPkgMap);
        for (String groupname : Grouplist) {
            int Groupcodeline = 0;
            int[] groupmonthtotaldata = new int[12];
            for (int i = 0; i < 12; i++) {
                groupmonthtotaldata[i] = 0;
            }
            String[] grouppkgtmp = GroupPkgjson.getString(groupname).split("#");
            for (JSONObject jsonobject : jsonList) {
                String pkgname = jsonobject.getString("pkgname").toUpperCase();
                for (String pkgnametmp : grouppkgtmp) {
                    if (pkgname.equals(pkgnametmp.toUpperCase())) {
                        String codelinenum = jsonobject.getString("codenum");
                        Groupcodeline += Integer.valueOf(codelinenum).intValue();
                        for (int i = 0; i < 12; i++) {
                            String monthname = "monthtotal" + (i + 1);
                            groupmonthtotaldata[i] += Integer.valueOf(jsonobject.getString(monthname)).intValue();
                        }
                    }
                }
            }
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("pkgname", groupname);
            jsonobj.put("codenum", Groupcodeline);
            for (int i = 0; i < 12; i++) {
                String monthname = "monthtotal" + (i + 1);
                jsonobj.put(monthname, groupmonthtotaldata[i]);
            }
            groupjsonList.add(jsonobj);
        }
        return groupjsonList;
    }

    public List<JSONObject> getDeptCodeLineInfoByDept(List<JSONObject> jsonList) {

        List<JSONObject> deptjsonList = new ArrayList<JSONObject>();
        String[] deptlist = {"平台一部", "平台四部", "平台五部", "平台六部"};
        String GroupPkgMap = "{\"平台一部\":\"管理专业组#品质专业组#系统专业1组#系统专业2组\",\"平台四部\":\"认证专业组#二层组#安全专业组\",\"平台五部\":\"应用专业组#三层专业组#出口专业组\",\"平台六部\":\"DC专业组#IGP专业组#EGP专业组#MCAST专业组#MPLS专业组\"}";
        JSONObject GroupPkgjson = JSONObject.fromObject(GroupPkgMap);
        for (String groupname : deptlist) {
            int Groupcodeline = 0;
            int[] groupmonthtotaldata = new int[12];
            for (int i = 0; i < 12; i++) {
                groupmonthtotaldata[i] = 0;
            }
            String[] grouppkgtmp = GroupPkgjson.getString(groupname).split("#");
            for (JSONObject jsonobject : jsonList) {
                String pkgname = jsonobject.getString("pkgname");
                for (String pkgnametmp : grouppkgtmp) {
                    if (pkgname.equals(pkgnametmp)) {
                        String codelinenum = jsonobject.getString("codenum");
                        Groupcodeline += Integer.valueOf(codelinenum).intValue();
                        for (int i = 0; i < 12; i++) {
                            String monthname = "monthtotal" + (i + 1);
                            groupmonthtotaldata[i] += Integer.valueOf(jsonobject.getString(monthname)).intValue();
                        }
                    }
                }
            }
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("pkgname", groupname);
            jsonobj.put("codenum", Groupcodeline);
            for (int i = 0; i < 12; i++) {
                String monthname = "monthtotal" + (i + 1);
                jsonobj.put(monthname, groupmonthtotaldata[i]);
            }
            deptjsonList.add(jsonobj);
        }
        return deptjsonList;
    }

    /**
     * <p>Description: 根据时间和类型获取CafSvnInfo数据</p>
     * <p>Create Time: 2018/5/31 </p>
     *
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.CafSvnInfo>
     * @throws
     * @author zhengchengbin
     */
    public List<SvnMessage> getCodeLineBySvn(String timeS, String timeE, String type) {
        List<SvnMessage> svnInfoList = new ArrayList<SvnMessage>();
        if (type == "") {
            svnInfoList = efficientServiceDao.getCodeLineBySvn(timeS, timeE);
        }
        return svnInfoList;
    }

    /**
     * <p>Description: </p>
     * <p>Create Time: 2018/5/31 </p>
     *
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.CafCodeInfo>
     * @throws
     * @author zhengchengbin
     */
    public List<CafCodeInfo> getEachPersonByProject(String timeS, String timeE, String project) {

        List<CafCodeInfo> cafCodeList = new ArrayList<CafCodeInfo>();
        List<CafCodeInfo> codeInfoListTmp = new ArrayList<CafCodeInfo>();
        List<CafCodeInfo> codeInfoListAns = new ArrayList<CafCodeInfo>();
        List<String> nameList = getPersonName(timeS, timeE, project);
        cafCodeList = efficientServiceDao.getCodeInfoByTime(timeS, timeE);
        for (String name : nameList) {
            for (CafCodeInfo cafCodeInfo : cafCodeList) {
                if (cafCodeInfo.getUsername().equalsIgnoreCase(name)) {
                    codeInfoListTmp.add(cafCodeInfo);
                }
            }
            int codeNum = 0;
            int addCodeLineSum = 0;
            int delCodeLineSum = 0;
            CafCodeInfo cafCodeInfoAns = new CafCodeInfo();
            for (CafCodeInfo cafCodeInfo : codeInfoListTmp) {
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
            codeInfoListAns.add(cafCodeInfoAns);
        }
        return codeInfoListAns;
    }

    /**
     * <p>Description: </p>
     * <p>Create Time: 2018/5/31 </p>
     *
     * @param
     * @return java.util.List<java.lang.String>
     * @throws
     * @author zhengchengbin
     */
    public List<String> getPersonName(String timeS, String timeE, String project) {

        List<String> nameList = new ArrayList<String>();
        nameList = efficientServiceDao.getPersonNameByProject(timeS, timeE,project);
        return nameList;
    }

    /**
     * <p>Description: 按分页大小和查询条件返回Qualification数据 </p>
     * <p>Create Time: 2018/5/31 </p>
     *
     * @param
     * @return com.ruijie.rgcc.entity.EasyuiResult
     * @throws
     * @author zhengchengbin
     */
    public EasyuiResult getQualification(String dept, String group, String username, String type,
                                         int pageSize, int pageNum) {

        List<Qualification> qualInfoList = new ArrayList<Qualification>();

        if (type.equals("dept")) {
            qualInfoList = efficientServiceDao.getQualificationByDept(dept);
        } else if (type.equals("group")) {
            qualInfoList = efficientServiceDao.getQualificationByGroup(dept, group);
        } else if (type.equals("user")) {
            qualInfoList = efficientServiceDao.getQualificationByUserName(dept, group, username);
        } else if (type.equals("all")) {
            qualInfoList = efficientServiceDao.getAllQualification();
        } else {
            logger.error("don't catch qualification type");
        }
        List<Qualification> subQualInfoList = null;
        if (!type.equals("user")) {
            int first = (pageNum - 1) * pageSize;
            int end = (pageNum) * pageSize < qualInfoList.size() ? (pageNum) * pageSize : qualInfoList.size();
            subQualInfoList = qualInfoList.subList(first, end);
        } else {
            subQualInfoList = qualInfoList;
        }
        EasyuiResult er = new EasyuiResult();
        er.setTotal(qualInfoList.size());
        er.setRows(subQualInfoList);
        return er;
    }

    /**
     * <p>Description: 更新qualification对象数据</p>
     * <p>Create Time: 2018/5/31 </p>
     *
     * @param
     * @return java.lang.String
     * @throws
     * @author zhengchengbin
     */

    public String updateQualification(Qualification qualification) {

        boolean message = efficientServiceDao.updateQualification(qualification);
        if (message) {
            return "success";
        }
        return "error";
    }



}

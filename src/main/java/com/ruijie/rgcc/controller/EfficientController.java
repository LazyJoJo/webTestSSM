package com.ruijie.rgcc.controller;

import com.ruijie.rgcc.entity.CafCodeInfo;
import com.ruijie.rgcc.entity.Qualification;
import com.ruijie.rgcc.entity.ResMngRecordInfo;
import com.ruijie.rgcc.entity.SvnMessage;
import com.ruijie.rgcc.entity.EasyuiResult;
import com.ruijie.rgcc.inter.EfficientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * <p>Title: EfficientController </p>
 * <p>Description: 效率可视化系统的控制器类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/28 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
@Controller
@RequestMapping(value = "/efficient")
public class EfficientController {
    /**
     *  EfficientService
     */
    @Resource
    private EfficientService efficientService;

    /**
     * <p>Description: 获取每个人代码量</p>
     * <p>Create Time: 2018/5/28 </p>
     * @author zhengchengbin
     * @param httpServletRequest
     * @return java.util.List<com.ruijie.rgcc.entity.CafCodeInfo>
     * @throws
     */
    @RequestMapping(value = "/getEachPersonCodeLine", method = RequestMethod.POST)
    @ResponseBody
    public List<CafCodeInfo> getEachPersonCodeLine(HttpServletRequest httpServletRequest) {
        List<CafCodeInfo> cafCodeInfos = new ArrayList<CafCodeInfo>();
        String timeStart = httpServletRequest.getParameter("timeS");
        String timeEnd = httpServletRequest.getParameter("timeE");
        String project = httpServletRequest.getParameter("project");
        cafCodeInfos = efficientService.getEachPersonByProject(timeStart, timeEnd, project);
        return cafCodeInfos;
    }

    /**
     * <p>Description: 获取svn上代码量数据 </p>
     * <p>Create Time: 2018/5/29 </p>
     * @author zhengchengbin
     * @param httpServletRequest
     * @return java.lang.Object
     * @throws
     */
    @RequestMapping(value = "/getCodeLineBySvn", method = RequestMethod.POST)
    @ResponseBody
    public Object getcodelineBysvn(HttpServletRequest httpServletRequest) {
        List<SvnMessage> svnMessages = new ArrayList<SvnMessage>();
        String timeStart = httpServletRequest.getParameter("timeS");
        String timeEnd = httpServletRequest.getParameter("timeE");
        String type = httpServletRequest.getParameter("type");
        svnMessages = efficientService.getCodeLineBySvn(timeStart, timeEnd, type);
        return svnMessages;
    }

    /**
     * <p>Description: 根据查询条件获取代码量数据 </p>
     * <p>Create Time: 2018/5/30 </p>
     * @author zhengchengbin
     * @param httpServletRequest
     * @return java.util.List<net.sf.json.JSONObject>
     * @throws
     */
    @RequestMapping(value = "/getCodeLineInfo", method = RequestMethod.POST)
    public List<JSONObject> getCodeLineInfo(HttpServletRequest httpServletRequest) {
        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        String year = httpServletRequest.getParameter("year");
        String project = httpServletRequest.getParameter("project");
        String timeStart = httpServletRequest.getParameter("timeS");
        String timeEnd = httpServletRequest.getParameter("timeE");
        String department = httpServletRequest.getParameter("dept");
        String group = httpServletRequest.getParameter("group");
        String pkgName = httpServletRequest.getParameter("pkgname");
        String userName = httpServletRequest.getParameter("username");
        String queryType = httpServletRequest.getParameter("querytype");
        if (timeEnd == "") {
            timeEnd = "12-31";
        }
        if (timeStart == "") {
            timeStart = "01-01";
        }
        ResMngRecordInfo resMngRecordInfo = new ResMngRecordInfo();
        resMngRecordInfo.setResProjectName(project);
        resMngRecordInfo.setResWeekStartDate(year + "-" + timeStart);
        resMngRecordInfo.setResWeekEndDate(year + "-" + timeEnd);
        resMngRecordInfo.setDepartment(department);
        resMngRecordInfo.setGroupName(group);
        resMngRecordInfo.setUserInfoName(userName);
        resMngRecordInfo.setResWorkPackName(pkgName);
        jsonObjects = efficientService.getCodeLineInfo(queryType, resMngRecordInfo);
        return jsonObjects;
    }

    /**
     * <p>Description: </p>
     * <p>Create Time: 2018/5/31 </p>
     * @author zhengchengbin
     * @param httpServletRequest
     * @return com.ruijie.rgcc.entity.EasyuiResult
     * @throws
     */
    @RequestMapping(value = "/getQualification", method = RequestMethod.POST)
    @ResponseBody
    public EasyuiResult getQualification(HttpServletRequest httpServletRequest) {
        EasyuiResult er = null;
        String dept = httpServletRequest.getParameter("dept");
        String group = httpServletRequest.getParameter("group");
        String username = httpServletRequest.getParameter("username");
        String type = httpServletRequest.getParameter("type");
        int pageSize = 0;
        int pageNum = 0;
        if (!type.equals("user")) {
            pageSize = Integer.valueOf(httpServletRequest.getParameter("rows"));
            pageNum = Integer.valueOf(httpServletRequest.getParameter("page"));
        }
        er = efficientService.getQualification(dept, group, username, type, pageSize, pageNum);
        return er;
    }

    /**
     * <p>Description: </p>
     * <p>Create Time: 2018/6/1 </p>
     * @author zhengchengbin
     * @param httpServletRequest
     * @return java.lang.String
     * @throws
     */
    @RequestMapping(value = "/updateQualification", method = RequestMethod.POST)
    @ResponseBody
    public String updateQualification(HttpServletRequest httpServletRequest) {
        String userName = httpServletRequest.getParameter("userName");
        String group = httpServletRequest.getParameter("group");
        String department = httpServletRequest.getParameter("department");
        String q1Qual = httpServletRequest.getParameter("q1Qual");
        String q2Qual = httpServletRequest.getParameter("q2Qual");
        String q3Qual = httpServletRequest.getParameter("q3Qual");
        String q4Qual = httpServletRequest.getParameter("q4Qual");
        String q1TrueQual = httpServletRequest.getParameter("q1TrueQual");
        String q2TrueQual = httpServletRequest.getParameter("q2TrueQual");
        String q3TrueQual = httpServletRequest.getParameter("q3TrueQual");
        String q4TrueQual = httpServletRequest.getParameter("q4TrueQual");
        String curQual = httpServletRequest.getParameter("curQual");
        String preQual = httpServletRequest.getParameter("preQual");
        String qualFileName = httpServletRequest.getParameter("qualFileName");
        String qualFileNum = httpServletRequest.getParameter("qualFileNum");
        Qualification qualification = new Qualification(userName, group, department, curQual, preQual, q1Qual, q2Qual, q3Qual,
                q4Qual, q1TrueQual, q2TrueQual, q3TrueQual, q4TrueQual, qualFileName, qualFileNum);
        String message = efficientService.updateQualification(qualification);
        return message;
    }
}

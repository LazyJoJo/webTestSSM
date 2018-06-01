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
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
@Controller
@RequestMapping(value = "/efficient")
public class EfficientController {
    @Resource
    private EfficientService EfficientService;

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
        List<CafCodeInfo> cafCodeList = new ArrayList<CafCodeInfo>();
        String timeS = httpServletRequest.getParameter("timeS");
        String timeE = httpServletRequest.getParameter("timeE");
        String project = httpServletRequest.getParameter("project");
        cafCodeList = EfficientService.getEachPersonByProject(timeS, timeE, project);
        return cafCodeList;
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
        List<SvnMessage> svnMessagesList = new ArrayList<SvnMessage>();
        String timeStart = httpServletRequest.getParameter("timeS");
        String timeEnd = httpServletRequest.getParameter("timeE");
        String type = httpServletRequest.getParameter("type");
        svnMessagesList = EfficientService.getCodeLineBySvn(timeStart, timeEnd, type);
        return svnMessagesList;
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
        List<JSONObject> jsonList = new ArrayList<JSONObject>();
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
        resMngRecordInfo.setRes_project_name(project);
        resMngRecordInfo.setRes_week_start_date(year + "-" + timeStart);
        resMngRecordInfo.setRes_week_end_date(year + "-" + timeEnd);
        resMngRecordInfo.setDepartment(department);
        resMngRecordInfo.setGroup_name(group);
        resMngRecordInfo.setUser_info_name(userName);
        resMngRecordInfo.setRes_work_pack_name(pkgName);
        List<CafCodeInfo> codeList = new ArrayList<CafCodeInfo>();
        jsonList = EfficientService.getCodeLineInfo(queryType, resMngRecordInfo);
        return jsonList;
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
        er = EfficientService.getQualification(dept, group, username, type, pageSize, pageNum);
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
        String message = EfficientService.updateQualification(qualification);
        return message;
    }
}

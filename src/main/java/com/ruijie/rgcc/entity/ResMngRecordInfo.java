package com.ruijie.rgcc.entity;

/**
 * <p>Title: ResMngRecordInfo </p>
 * <p>Description: 人员资源统计视图实体类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/25 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public class ResMngRecordInfo {

    /**
     * 工作周ID
     */
    private String weekId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userInfoName;

    /**
     * 专业组名称
     */
    private String groupName;

    /**
     * 部门名称
     */
    private String department;

    /**
     * 事业部名称
     */
    private String BusinessDep;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务目标
     */
    private String taskTarget;

    /**
     * 专用产品
     */
    private String specificProduce;

    /**
     * 产品评价
     */
    private String produceEvaluation;

    /**
     * 任务完成数量
     */
    private String taskComplete;

    /**
     * 标记
     */
    private String remarks;

    /**
     * 工作时长
     */
    private String workTime;

    /**
     * 加班时长
     */
    private String addTime;

    /**
     * 总时长
     */
    private String TotalTime;

    /**
     * 工作项目类型编号
     */
    private String workClassId;

    /**
     * 项目类型名称
     */
    private String workClassName;

    /**
     * 项目编号
     */
    private String resProjectId;

    /**
     * 项目名称
     */
    private String resProjectName;

    /**
     * 工作库ID
     */
    private String resWorkPackId;

    /**
     * 工作库名
     */
    private String resWorkPackName;

    /**
     * 测试类型ID
     */
    private String resTaskClassId;

    /**
     * 测试类型名称
     */
    private String resTaskClassName;

    /**
     * 平台ID
     */
    private String resForDicisionId;

    /**
     * 平台名称
     */
    private String resForDicisionName;

    /**
     * 优先级ID
     */
    private String resPriorityId;

    /**
     * 优先级名称
     */
    private String resPriorityName;

    /**
     * 开始周时间
     */
    private String resWeekStartDate;

    /**
     * 结束周时间
     */
    private String resWeekEndDate;

    /**
     * 周时间
     */
    private String week;

    /**
     * constructor
     */
    public ResMngRecordInfo() {
        this.weekId = "";
        this.userId = "";
        this.userInfoName = "";
        this.groupName = "";
        this.department = "";
        this.BusinessDep = "";
        this.taskName = "";
        this.taskTarget = "";
        this.specificProduce = "";
        this.produceEvaluation = "";
        this.taskComplete = "";
        this.remarks = "";
        this.workTime = "";
        this.addTime = "";
        this.TotalTime = "";
        this.workClassId = "";
        this.workClassName = "";
        this.resProjectId = "";
        this.resProjectName = "";
        this.resWorkPackId = "";
        this.resWorkPackName = "";
        this.resTaskClassId = "";
        this.resTaskClassName = "";
        this.resForDicisionId = "";
        this.resForDicisionName = "";
        this.resPriorityId = "";
        this.resPriorityName = "";
        this.resWeekStartDate = "";
        this.resWeekEndDate = "";
        this.week = "";
    }

    /**
     * getter and setter
     */
    public String getWeekId() {
        return weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserInfoName() {
        return userInfoName;
    }

    public void setUserInfoName(String userInfoName) {
        this.userInfoName = userInfoName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBusinessDep() {
        return BusinessDep;
    }

    public void setBusinessDep(String businessDep) {
        BusinessDep = businessDep;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskTarget() {
        return taskTarget;
    }

    public void setTaskTarget(String taskTarget) {
        this.taskTarget = taskTarget;
    }

    public String getSpecificProduce() {
        return specificProduce;
    }

    public void setSpecificProduce(String specificProduce) {
        this.specificProduce = specificProduce;
    }

    public String getProduceEvaluation() {
        return produceEvaluation;
    }

    public void setProduceEvaluation(String produceEvaluation) {
        this.produceEvaluation = produceEvaluation;
    }

    public String getTaskComplete() {
        return taskComplete;
    }

    public void setTaskComplete(String taskComplete) {
        this.taskComplete = taskComplete;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(String totalTime) {
        TotalTime = totalTime;
    }

    public String getWorkClassId() {
        return workClassId;
    }

    public void setWorkClassId(String workClassId) {
        this.workClassId = workClassId;
    }

    public String getWorkClassName() {
        return workClassName;
    }

    public void setWorkClassName(String workClassName) {
        this.workClassName = workClassName;
    }

    public String getResProjectId() {
        return resProjectId;
    }

    public void setResProjectId(String resProjectId) {
        this.resProjectId = resProjectId;
    }

    public String getResProjectName() {
        return resProjectName;
    }

    public void setResProjectName(String resProjectName) {
        this.resProjectName = resProjectName;
    }

    public String getResWorkPackId() {
        return resWorkPackId;
    }

    public void setResWorkPackId(String resWorkPackId) {
        this.resWorkPackId = resWorkPackId;
    }

    public String getResWorkPackName() {
        return resWorkPackName;
    }

    public void setResWorkPackName(String resWorkPackName) {
        this.resWorkPackName = resWorkPackName;
    }

    public String getResTaskClassId() {
        return resTaskClassId;
    }

    public void setResTaskClassId(String resTaskClassId) {
        this.resTaskClassId = resTaskClassId;
    }

    public String getResTaskClassName() {
        return resTaskClassName;
    }

    public void setResTaskClassName(String resTaskClassName) {
        this.resTaskClassName = resTaskClassName;
    }

    public String getResForDicisionId() {
        return resForDicisionId;
    }

    public void setResForDicisionId(String resForDicisionId) {
        this.resForDicisionId = resForDicisionId;
    }

    public String getResForDicisionName() {
        return resForDicisionName;
    }

    public void setResForDicisionName(String resForDicisionName) {
        this.resForDicisionName = resForDicisionName;
    }

    public String getResPriorityId() {
        return resPriorityId;
    }

    public void setResPriorityId(String resPriorityId) {
        this.resPriorityId = resPriorityId;
    }

    public String getResPriorityName() {
        return resPriorityName;
    }

    public void setResPriorityName(String resPriorityName) {
        this.resPriorityName = resPriorityName;
    }

    public String getResWeekStartDate() {
        return resWeekStartDate;
    }

    public void setResWeekStartDate(String resWeekStartDate) {
        this.resWeekStartDate = resWeekStartDate;
    }

    public String getResWeekEndDate() {
        return resWeekEndDate;
    }

    public void setResWeekEndDate(String resWeekEndDate) {
        this.resWeekEndDate = resWeekEndDate;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}

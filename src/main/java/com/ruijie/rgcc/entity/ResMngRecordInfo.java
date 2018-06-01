package com.ruijie.rgcc.entity;

/**
 * <p>Title: ResMngRecordInfo </p>
 * <p>Description: 人员资源统计视图实体类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/25 </p>
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public class ResMngRecordInfo {

    /**
     * 工作周ID
     */
    private String week_id;

    /**
     * 用户ID
     */
    private String user_id;

    /**
     * 用户名称
     */
    private String user_info_name;

    /**
     * 专业组名称
     */
    private String group_name;

    /**
     * 部门名称
     */
    private String department;

    /**
     * 事业部名称
     */
    private String Business_dep;

    /**
     * 任务名称
     */
    private String task_name;

    /**
     * 任务目标
     */
    private String task_target;

    /**
     * 专用产品
     */
    private String specific_produce;

    /**
     * 产品评价
     */
    private String produce_evaluation;

    /**
     * 任务完成数量
     */
    private String task_complete;

    /**
     * 标记
     */
    private String remarks;

    /**
     * 工作时长
     */
    private String work_time;

    /**
     * 加班时长
     */
    private String add_time;

    /**
     * 总时长
     */
    private String Total_time;

    /**
     * 工作项目类型编号
     */
    private String work_class_id;

    /**
     * 项目类型名称
     */
    private String work_class_name;

    /**
     * 项目编号
     */
    private String res_project_id;

    /**
     * 项目名称
     */
    private String res_project_name;

    /**
     * 工作库ID
     */
    private String res_work_pack_id;

    /**
     * 工作库名
     */
    private String res_work_pack_name;

    /**
     * 测试类型ID
     */
    private String res_task_class_id;

    /**
     * 测试类型名称
     */
    private String res_task_class_name;

    /**
     * 平台ID
     */
    private String res_for_dicision_id;

    /**
     * 平台名称
     */
    private String res_for_dicision_name;

    /**
     * 优先级ID
     */
    private String res_priority_id;

    /**
     * 优先级名称
     */
    private String res_priority_name;

    /**
     * 开始周时间
     */
    private String res_week_start_date;

    /**
     * 结束周时间
     */
    private String res_week_end_date;

    /**
     * 周时间
     */
    private String week;

    /**
     * constructor
     */
    public ResMngRecordInfo() {
        this.week_id = "";
        this.user_id = "";
        this.user_info_name = "";
        this.group_name = "";
        this.department = "";
        this.Business_dep = "";
        this.task_name = "";
        this.task_target = "";
        this.specific_produce = "";
        this.produce_evaluation = "";
        this.task_complete = "";
        this.remarks = "";
        this.work_time = "";
        this.add_time = "";
        this.Total_time = "";
        this.work_class_id = "";
        this.work_class_name = "";
        this.res_project_id = "";
        this.res_project_name = "";
        this.res_work_pack_id = "";
        this.res_work_pack_name = "";
        this.res_task_class_id = "";
        this.res_task_class_name = "";
        this.res_for_dicision_id = "";
        this.res_for_dicision_name = "";
        this.res_priority_id = "";
        this.res_priority_name = "";
        this.res_week_start_date = "";
        this.res_week_end_date = "";
        this.week = "";
    }

    /**
     * getter and setter
     */
    public String getWeek_id() {
        return week_id;
    }

    public void setWeek_id(String week_id) {
        this.week_id = week_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_info_name() {
        return user_info_name;
    }

    public void setUser_info_name(String user_info_name) {
        this.user_info_name = user_info_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBusiness_dep() {
        return Business_dep;
    }

    public void setBusiness_dep(String business_dep) {
        Business_dep = business_dep;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_target() {
        return task_target;
    }

    public void setTask_target(String task_target) {
        this.task_target = task_target;
    }

    public String getSpecific_produce() {
        return specific_produce;
    }

    public void setSpecific_produce(String specific_produce) {
        this.specific_produce = specific_produce;
    }

    public String getProduce_evaluation() {
        return produce_evaluation;
    }

    public void setProduce_evaluation(String produce_evaluation) {
        this.produce_evaluation = produce_evaluation;
    }

    public String getTask_complete() {
        return task_complete;
    }

    public void setTask_complete(String task_complete) {
        this.task_complete = task_complete;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getTotal_time() {
        return Total_time;
    }

    public void setTotal_time(String total_time) {
        Total_time = total_time;
    }

    public String getWork_class_id() {
        return work_class_id;
    }

    public void setWork_class_id(String work_class_id) {
        this.work_class_id = work_class_id;
    }

    public String getWork_class_name() {
        return work_class_name;
    }

    public void setWork_class_name(String work_class_name) {
        this.work_class_name = work_class_name;
    }

    public String getRes_project_id() {
        return res_project_id;
    }

    public void setRes_project_id(String res_project_id) {
        this.res_project_id = res_project_id;
    }

    public String getRes_project_name() {
        return res_project_name;
    }

    public void setRes_project_name(String res_project_name) {
        this.res_project_name = res_project_name;
    }

    public String getRes_work_pack_id() {
        return res_work_pack_id;
    }

    public void setRes_work_pack_id(String res_work_pack_id) {
        this.res_work_pack_id = res_work_pack_id;
    }

    public String getRes_work_pack_name() {
        return res_work_pack_name;
    }

    public void setRes_work_pack_name(String res_work_pack_name) {
        this.res_work_pack_name = res_work_pack_name;
    }

    public String getRes_task_class_id() {
        return res_task_class_id;
    }

    public void setRes_task_class_id(String res_task_class_id) {
        this.res_task_class_id = res_task_class_id;
    }

    public String getRes_task_class_name() {
        return res_task_class_name;
    }

    public void setRes_task_class_name(String res_task_class_name) {
        this.res_task_class_name = res_task_class_name;
    }

    public String getRes_for_dicision_id() {
        return res_for_dicision_id;
    }

    public void setRes_for_dicision_id(String res_for_dicision_id) {
        this.res_for_dicision_id = res_for_dicision_id;
    }

    public String getRes_for_dicision_name() {
        return res_for_dicision_name;
    }

    public void setRes_for_dicision_name(String res_for_dicision_name) {
        this.res_for_dicision_name = res_for_dicision_name;
    }

    public String getRes_priority_id() {
        return res_priority_id;
    }

    public void setRes_priority_id(String res_priority_id) {
        this.res_priority_id = res_priority_id;
    }

    public String getRes_priority_name() {
        return res_priority_name;
    }

    public void setRes_priority_name(String res_priority_name) {
        this.res_priority_name = res_priority_name;
    }

    public String getRes_week_start_date() {
        return res_week_start_date;
    }

    public void setRes_week_start_date(String res_week_start_date) {
        this.res_week_start_date = res_week_start_date;
    }

    public String getRes_week_end_date() {
        return res_week_end_date;
    }

    public void setRes_week_end_date(String res_week_end_date) {
        this.res_week_end_date = res_week_end_date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}

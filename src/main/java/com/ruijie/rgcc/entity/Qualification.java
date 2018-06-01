package com.ruijie.rgcc.entity;
/**
 * <p>Title: Qualification </p>
 * <p>Description: 人员资质数据实体类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/24 </p>
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public class Qualification {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 小组名称
     */
    private String groupName;

    /**
     * 部门名称
     */
    private String department;

    /**
     * 当前资质
     */
    private String curQual;

    /**
     * 年初资质
     */
    private String preQual;

    /**
     * Q1目标资质
     */
    private String q1Qual;

    /**
     * Q2目标资质
     */
    private String q2Qual;

    /**
     * Q3目标资质
     */
    private String q3Qual;

    /**
     * Q4目标资质
     */
    private String q4Qual;

    /**
     * Q1实际资质
     */
    private String q1TrueQual;

    /**
     * Q2实际资质
     */
    private String q2TrueQual;

    /**
     * Q3实际资质
     */
    private String q3TrueQual;

    /**
     * Q3实际资质
     */
    private String q4TrueQual;

    /**
     * 资质文档名称
     */
    private String qualFileName;

    /**
     * 资质文档数量
     */
    private String qualFileNum;

    /**
     * constructor
     */
    public Qualification() {
        this.userName = "";
        this.groupName = "";
        this.department = "";
        this.curQual = "";
        this.preQual = "";
        this.q1Qual = "";
        this.q2Qual = "";
        this.q3Qual = "";
        this.q4Qual = "";
        this.q1TrueQual = "";
        this.q2TrueQual = "";
        this.q3TrueQual = "";
        this.q4TrueQual = "";
        this.qualFileName = "";
        this.qualFileNum = "";
    }

    public Qualification(String userName, String groupName, String department, String curQual, String preQual,
                         String q1Qual, String q2Qual, String q3Qual, String q4Qual, String q1TrueQual,
                         String q2TrueQual, String q3TrueQual, String q4TrueQual, String qualFileName,
                         String qualFileNum) {
        this.userName = userName;
        this.groupName = groupName;
        this.department = department;
        this.curQual = curQual;
        this.preQual = preQual;
        this.q1Qual = q1Qual;
        this.q2Qual = q2Qual;
        this.q3Qual = q3Qual;
        this.q4Qual = q4Qual;
        this.q1TrueQual = q1TrueQual;
        this.q2TrueQual = q2TrueQual;
        this.q3TrueQual = q3TrueQual;
        this.q4TrueQual = q4TrueQual;
        this.qualFileName = qualFileName;
        this.qualFileNum = qualFileNum;
    }

    /**
     * getter and setter
     */
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getCurQual() {
        return curQual;
    }

    public void setCurQual(String curQual) {
        this.curQual = curQual == null ? null : curQual.trim();
    }

    public String getPreQual() {
        return preQual;
    }

    public void setPreQual(String preQual) {
        this.preQual = preQual == null ? null : preQual.trim();
    }

    public String getQ1Qual() {
        return q1Qual;
    }

    public void setQ1Qual(String q1Qual) {
        this.q1Qual = q1Qual == null ? null : q1Qual.trim();
    }

    public String getQ2Qual() {
        return q2Qual;
    }

    public void setQ2Qual(String q2Qual) {
        this.q2Qual = q2Qual == null ? null : q2Qual.trim();
    }

    public String getQ3Qual() {
        return q3Qual;
    }

    public void setQ3Qual(String q3Qual) {
        this.q3Qual = q3Qual == null ? null : q3Qual.trim();
    }

    public String getQ4Qual() {
        return q4Qual;
    }

    public void setQ4Qual(String q4Qual) {
        this.q4Qual = q4Qual == null ? null : q4Qual.trim();
    }

    public String getQ1TrueQual() {
        return q1TrueQual;
    }

    public void setQ1TrueQual(String q1TrueQual) {
        this.q1TrueQual = q1TrueQual == null ? null : q1TrueQual.trim();
    }

    public String getQ2TrueQual() {
        return q2TrueQual;
    }

    public void setQ2TrueQual(String q2TrueQual) {
        this.q2TrueQual = q2TrueQual == null ? null : q2TrueQual.trim();
    }

    public String getQ3TrueQual() {
        return q3TrueQual;
    }

    public void setQ3TrueQual(String q3TrueQual) {
        this.q3TrueQual = q3TrueQual == null ? null : q3TrueQual.trim();
    }

    public String getQ4TrueQual() {
        return q4TrueQual;
    }

    public void setQ4TrueQual(String q4TrueQual) {
        this.q4TrueQual = q4TrueQual == null ? null : q4TrueQual.trim();
    }

    public String getQualFileName() {
        return qualFileName;
    }

    public void setQualFileName(String qualFileName) {
        this.qualFileName = qualFileName == null ? null : qualFileName.trim();
    }

    public String getQualFileNum() {
        return qualFileNum;
    }

    public void setQualFileNum(String qualFileNum) {
        this.qualFileNum = qualFileNum == null ? null : qualFileNum.trim();
    }
}
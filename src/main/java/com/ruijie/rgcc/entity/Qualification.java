package com.ruijie.rgcc.entity;

public class Qualification {
    private String userName;

    private String groupName;

    private String department;

    private String curQual;

    private String preQual;

    private String q1Qual;

    private String q2Qual;

    private String q3Qual;

    private String q4Qual;

    private String q1TrueQual;

    private String q2TrueQual;

    private String q3TrueQual;

    private String q4TrueQual;

    private String qualFileName;

    private String qualFileNum;

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
package com.ruijie.rgcc.entity;

public class SvnMessage {
    private String svnPath;

    private String fileName;

    private String fileType;

    private String modifyType;

    private String isFile;

    private String modifyNum;

    private String allCLine;

    private String addCLine;

    private String delCLine;

    private String allELine;

    private String addELine;

    private String delELine;

    private String allZLine;

    private String addZLine;

    private String delZLine;

    private String group;

    public String getSvnPath() {
        return svnPath;
    }

    public void setSvnPath(String svnPath) {
        this.svnPath = svnPath == null ? null : svnPath.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType == null ? null : modifyType.trim();
    }

    public String getIsFile() {
        return isFile;
    }

    public void setIsFile(String isFile) {
        this.isFile = isFile == null ? null : isFile.trim();
    }

    public String getModifyNum() {
        return modifyNum;
    }

    public void setModifyNum(String modifyNum) {
        this.modifyNum = modifyNum == null ? null : modifyNum.trim();
    }

    public String getAllCLine() {
        return allCLine;
    }

    public void setAllCLine(String allCLine) {
        this.allCLine = allCLine == null ? null : allCLine.trim();
    }

    public String getAddCLine() {
        return addCLine;
    }

    public void setAddCLine(String addCLine) {
        this.addCLine = addCLine == null ? null : addCLine.trim();
    }

    public String getDelCLine() {
        return delCLine;
    }

    public void setDelCLine(String delCLine) {
        this.delCLine = delCLine == null ? null : delCLine.trim();
    }

    public String getAllELine() {
        return allELine;
    }

    public void setAllELine(String allELine) {
        this.allELine = allELine == null ? null : allELine.trim();
    }

    public String getAddELine() {
        return addELine;
    }

    public void setAddELine(String addELine) {
        this.addELine = addELine == null ? null : addELine.trim();
    }

    public String getDelELine() {
        return delELine;
    }

    public void setDelELine(String delELine) {
        this.delELine = delELine == null ? null : delELine.trim();
    }

    public String getAllZLine() {
        return allZLine;
    }

    public void setAllZLine(String allZLine) {
        this.allZLine = allZLine == null ? null : allZLine.trim();
    }

    public String getAddZLine() {
        return addZLine;
    }

    public void setAddZLine(String addZLine) {
        this.addZLine = addZLine == null ? null : addZLine.trim();
    }

    public String getDelZLine() {
        return delZLine;
    }

    public void setDelZLine(String delZLine) {
        this.delZLine = delZLine == null ? null : delZLine.trim();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }
}
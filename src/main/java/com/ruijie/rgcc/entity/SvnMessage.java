package com.ruijie.rgcc.entity;
/**
 * <p>Title: SvnMessage </p>
 * <p>Description: svn库数据信息实体类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/26 </p>
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public class SvnMessage {

    /**
     * svn路径
     */
    private String svnPath;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 代码修改类型
     */
    private String modifyType;

    /**
     * 是否是文件
     */
    private String isFile;

    /**
     * 代码修改数量
     */
    private String modifyNum;

    /**
     * 总变化条数
     */
    private String allCLine;

    /**
     * 增加条数
     */
    private String addCLine;

    /**
     * 删除条数
     */
    private String delCLine;

    /**
     * 总空行数
     */
    private String allELine;

    /**
     * 增加空行数
     */
    private String addELine;

    /**
     * 删除空行数
     */
    private String delELine;

    /**
     * 总注释行数
     */
    private String allZLine;

    /**
     * 增加注释行数
     */
    private String addZLine;

    /**
     * 删除注释行数
     */
    private String delZLine;

    /**
     * 专业组
     */
    private String group;

    /**
     * constructor
     */
    public SvnMessage() {
        this.svnPath = "";
        this.fileName = "";
        this.fileType = "";
        this.modifyType = "";
        this.isFile = "";
        this.modifyNum = "";
        this.allCLine = "";
        this.addCLine = "";
        this.delCLine = "";
        this.allELine = "";
        this.addELine = "";
        this.delELine = "";
        this.allZLine = "";
        this.addZLine = "";
        this.delZLine = "";
        this.group = "";
    }

    /**
     * getter and setter
     */
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
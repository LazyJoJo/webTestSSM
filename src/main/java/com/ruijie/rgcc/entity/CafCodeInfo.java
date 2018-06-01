package com.ruijie.rgcc.entity;

/**
 * <p>Title: CafCodeInfo </p>
 * <p>Description: 代码数据实体类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/22 </p>
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public class CafCodeInfo {

    /**
     *  主键ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 代码所属项目
     */
    private String project;

    /**
     * 代码所属组件包
     */
    private String pkg;

    /**
     * 版本分支
     */
    private String branch;

    /**
     * 提交时间
     */
    private String date;

    /**
     * 添加代码行数
     */
    private String addcodeline;

    /**
     * 删除代码行数
     */
    private String delcodeline;

    /**
     * 代码总行数
     */
    private String codelines;

    /**
     * 文件类型
     */
    private String citype;

    /**
     * 文件名
     */
    private String docname;

    /**
     * constructor
     */
    public CafCodeInfo() {
        id = null;
        username = null;
        pkg = null;
        branch = null;
        date = null;
        codelines = null;
        project = null;
        addcodeline = null;
        delcodeline = null;
        citype = null;
        docname = null;
    }

    /**
     * getter and setter
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCodelines() {
        return codelines;
    }

    public void setCodelines(String codelines) {
        this.codelines = codelines;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getAddcodeline() {
        return addcodeline;
    }

    public void setAddcodeline(String addcodeline) {
        this.addcodeline = addcodeline;
    }

    public String getDelcodeline() {
        return delcodeline;
    }

    public void setDelcodeline(String delcodeline) {
        this.delcodeline = delcodeline;
    }

    public String getCitype() {
        return citype;
    }

    public void setCitype(String citype) {
        this.citype = citype;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

}
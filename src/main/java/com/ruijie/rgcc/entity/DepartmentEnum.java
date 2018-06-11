package com.ruijie.rgcc.entity;
/**
 * <p>Title: DepartmentEnum </p>
 * <p>Description: 部门枚举类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/23 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public enum DepartmentEnum {
    /**
     * 枚举类型,key=部门，value=小组
     */
    PLATFORMONE("平台一部","管理专业组#品质专业组#系统专业1组#系统专业2组"),
    PLATFORMFOUR("平台四部","认证专业组#二层组#安全专业组"),
    PLATFORMFIVE("平台五部","应用专业组#三层专业组#出口专业组"),
    PLATFORMSIX("平台六部","DC专业组#IGP专业组#EGP专业组#MCAST专业组#MPLS专业组");

    /**
     * 部门名称
     */
    private String key;

    /**
     * 小组名称
     */
    private String value;

    /**
     * constructor
     */
    DepartmentEnum(String key,String value){
        this.key = key;
        this.value = value;
    }

    /**
     * getter
     */
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

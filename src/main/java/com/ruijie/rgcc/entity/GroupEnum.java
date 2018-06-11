package com.ruijie.rgcc.entity;
/**
 * <p>Title: GroupEnum </p>
 * <p>Description: 专业组枚举类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/23 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public enum GroupEnum {
    /**
     * 枚举类型,key=专业组，value=下属小组
     */
    MANAGE("管理专业组","mng#oam"), QUALITY("品质专业组","dev#ras"), SYSTEMMAJOR1("系统专业1组","bsp"),
    SYSTEMMAJOR2("系统专业2组","utils"), IDENTIFICATION("认证专业组","security"), SECONDFLOOR("二层组","lsm#bridge"),
    SAFETY("安全专业组","fw#ipfix#net_def"), APPLICATION("应用专业组","app"), THIRDFLOOR("三层专业组","ip#net"),
    EXPORT("出口专业组","vpn#UnifyManage#sslvpn"), DC("DC专业组","dc"), IGP("IGP专业组","libpub"), EGP("EGP专业组","ucast"),
    MCAST("MCAST专业组","MCAST#openflow"), MPLS("MPLS专业组","MPLS");

    /**
     * 专业组名称
     */
    private String key;

    /**
     * 下属小组名称
     */
    private String value;

    /**
     * constructor
     */
    GroupEnum(String key,String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * getter
     */
    public String getKey() {
        return this.key;
    }

    public String getValue(){
        return this.value;
    }
}

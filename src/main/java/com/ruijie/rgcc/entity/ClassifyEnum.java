package com.ruijie.rgcc.entity;
/**
 * <p>Title: ClassifyEnum </p>
 * <p>Description: 搜索类别枚举类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/23 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public enum ClassifyEnum {

    /**
     * 枚举类型
     */
    PACKAGE("pkg"),GROUP("group"),DEPARTMENT("dept");

    /**
     * 分类名称
     */
    private String name;

    /**
     * constructor
     */
    ClassifyEnum(String name){
        this.name = name;
    }

    /**
     * getter
     */
    public String getName(){
        return name;
    }
}

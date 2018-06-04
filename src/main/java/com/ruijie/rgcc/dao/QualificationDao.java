package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.Qualification;
import java.util.List;

/**
 * <p>Title: QualificationDao </p>
 * <p>Description: Qualification Dao </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/6/10 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public interface QualificationDao {

    /**
     * <p>Description: 插入数据 </p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param record
     * @return int
     * @throws
     */
    int insert(Qualification record);

    /**
     * <p>Description: 根据部门来获取资质信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param dept
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    List<Qualification> getQualificationByDept(String dept);

    /**
     * <p>Description: 根据小组来获取资质信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param dept, group
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    List<Qualification> getQualificationByGroup(String dept, String group);

    /**
     * <p>Description: 根据用户名来获取资质信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param dept, group, name
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    List<Qualification> getQualificationByUserName(String dept, String group, String name);

    /**
     * <p>Description: 获取所有资质信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    List<Qualification> getAllQualification();

    /**
     * <p>Description: 更新资质信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param qualification
     * @return boolean
     * @throws
     */
    boolean updateQualification(Qualification qualification);

}
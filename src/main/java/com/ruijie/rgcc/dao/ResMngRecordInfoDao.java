package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.ResMngRecordInfo;
import java.util.List;

/**
 * <p>Title: ResMngRecordInfoDao </p>
 * <p>Description: ResMngRecordInfo Dao </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/6/10 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public interface ResMngRecordInfoDao {

    /**
     * <p>Description: 获取用户信息表基本信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.ResMngRecordInfo>
     * @throws
     */
    List<ResMngRecordInfo> findUserGroupDeptInfo();

    /**
     * <p>Description: 获取平台信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.ResMngRecordInfo>
     * @throws
     */
    List<ResMngRecordInfo> findPatformResRecord();

    /**
     * <p>Description: 通过项目获取用户名信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd, project
     * @return java.util.List<java.lang.String>
     * @throws
     */
    List<String> getPersonNameByProject(String timeStart, String timeEnd, String project);
}

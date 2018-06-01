package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.ResMngRecordInfo;

import java.util.List;

public interface ResMngRecordInfoDao {
    List<ResMngRecordInfo> findUserGroupDeptInfo();
    List<ResMngRecordInfo> findPatformResRecord();
    List<String> getPersonNameByProject(String timeS, String timeE, String project);
}

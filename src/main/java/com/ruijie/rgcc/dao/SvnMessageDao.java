package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.SvnMessage;

import java.util.List;

public interface SvnMessageDao {
    int insert(SvnMessage record);

    int insertSelective(SvnMessage record);

    List<SvnMessage> getSvnMessageByTime(String timeS, String timeE);
}
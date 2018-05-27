package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.SvnMessage;

public interface SvnMessageDao {
    int insert(SvnMessage record);

    int insertSelective(SvnMessage record);
}
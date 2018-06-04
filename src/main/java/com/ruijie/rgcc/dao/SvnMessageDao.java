package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.SvnMessage;
import java.util.List;
/**
 * <p>Title: SvnMessageDao </p>
 * <p>Description: SvnMessage Dao </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/6/10 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public interface SvnMessageDao {

    /**
     * <p>Description: 插入完整数据</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param record
     * @return int
     * @throws
     */
    int insert(SvnMessage record);

    /**
     * <p>Description: 插入部分数据</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param record
     * @return int
     * @throws
     */
    int insertSelective(SvnMessage record);

    /**
     * <p>Description: 获取svn数据表信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd
     * @return java.util.List<com.ruijie.rgcc.entity.SvnMessage>
     * @throws
     */
    List<SvnMessage> getSvnMessageByTime(String timeStart, String timeEnd);
}
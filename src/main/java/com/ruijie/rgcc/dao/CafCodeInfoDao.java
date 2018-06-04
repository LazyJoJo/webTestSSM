package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.CafCodeInfo;
import java.util.List;

/**
 * <p>Title: CafCodeInfoDao </p>
 * <p>Description: CafCodeInfo Dao </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/6/10 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public interface CafCodeInfoDao {
    /**
     * <p>Description: 根据时间获取代码量信息</p>
     * <p>Create Time: 2018/6/10 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd
     * @return java.util.List<com.ruijie.rgcc.entity.CafCodeInfo>
     * @throws
     */
    List<CafCodeInfo> getCodeInfoByTime(String timeStart, String timeEnd);
}

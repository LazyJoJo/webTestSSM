package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.CafCodeInfo;
import com.ruijie.rgcc.entity.ResMngRecordInfo;

import java.util.List;

/**
 * <p>Title:                            </p>
 * <p>Description:                      </p>
 * <p>Copyright: Copyright (c) 2018     </p>
 * <p>Company: Ruijie Co., Ltd.         </p>
 * <p>Create Time:    2018/5/28         </p>
 * @author zhengchengbin
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public interface CafCodeInfoDao {
    List<CafCodeInfo> getCodeInfoByTime(String timeS, String timeE);
}

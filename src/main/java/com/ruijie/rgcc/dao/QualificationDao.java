package com.ruijie.rgcc.dao;

import com.ruijie.rgcc.entity.Qualification;

import java.util.List;

/**
 * <p>Title:    Qualification Dao       </p>
 * <p>Description:
 * This is qualification's dao          </p>
 * <p>Copyright: Copyright (c) 2018     </p>
 * <p>Company: Ruijie Co., Ltd.         </p>
 * <p>Create Time:    2018/5/26         </p>
 * @author          zhengchengbin
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public interface QualificationDao {
     /**
       * <p>Description:              </p>
       * <p>Create Time:   2018/5/26     </p>
       * @author zhengchengbin
       * @param record qualification 对象
       * @return int 插入条数
       * @throws
       */
     int insert(Qualification record);

      /**
        * <p>Description:              </p>
        * <p>Create Time:   2018/5/27     </p>
        * @author zhengchengbin
        * @param
        * @return List<Qualification> 对象列表
        * @throws
        */
     List<Qualification> findAll();

}
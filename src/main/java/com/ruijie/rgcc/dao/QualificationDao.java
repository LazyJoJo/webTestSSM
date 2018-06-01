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
 *
 * @author zhengchengbin
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public interface QualificationDao {
    /**
     * <p>Description:              </p>
     * <p>Create Time:   2018/5/26     </p>
     *
     * @param record qualification 对象
     * @return int 插入条数
     * @throws
     * @author zhengchengbin
     */
    int insert(Qualification record);

    /**
     * <p>Description:              </p>
     * <p>Create Time:   2018/5/27     </p>
     *
     * @param
     * @return List<Qualification> 对象列表
     * @throws
     * @author zhengchengbin
     */
    List<Qualification> findAll();

    List<Qualification> getQualificationByDept(String dept);

    List<Qualification> getQualificationByGroup(String dept, String group);

    List<Qualification> getQualificationByUserName(String dept, String group, String name);

    List<Qualification> getAllQualification();

    boolean updateQualification(Qualification qualification);

}
package com.ruijie.rgcc.service.dao;

import com.ruijie.rgcc.dao.CafCodeInfoDao;
import com.ruijie.rgcc.dao.QualificationDao;
import com.ruijie.rgcc.dao.ResMngRecordInfoDao;
import com.ruijie.rgcc.dao.SvnMessageDao;
import com.ruijie.rgcc.entity.CafCodeInfo;
import com.ruijie.rgcc.entity.Qualification;
import com.ruijie.rgcc.entity.ResMngRecordInfo;
import com.ruijie.rgcc.entity.SvnMessage;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title: EfficientServiceDao </p>
 * <p>Description: EfficientService Dao </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/6/9 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public class EfficientServiceDao {
    /**
     *  qualification dao
     */
    @Resource
    private QualificationDao qualificationDao;
    /**
     *  ResMngRecordInfo dao
     */
    @Resource
    private ResMngRecordInfoDao resMngRecordInfoDao;
    /**
     *  SvnMessage dao
     */
    @Resource
    private SvnMessageDao svnMessageDao;
    /**
     *  CafCodeInfo dao
     */
    @Resource
    private CafCodeInfoDao cafCodeInfoDao;


    /**
     * svnMessageDao use
     */

    /**
     * <p>Description: 获取svn数据表信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd
     * @return java.util.List<com.ruijie.rgcc.entity.SvnMessage>
     * @throws
     */
    public List<SvnMessage> getCodeLineBySvn(String timeStart, String timeEnd) {
        return svnMessageDao.getSvnMessageByTime(timeStart, timeEnd);
    }


    /**
     * cafCodeInfoDao use
     */

    /**
     * <p>Description: 根据时间获取代码量信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd
     * @return java.util.List<com.ruijie.rgcc.entity.CafCodeInfo>
     * @throws
     */
    public List<CafCodeInfo> getCodeInfoByTime(String timeStart, String timeEnd) {
        return cafCodeInfoDao.getCodeInfoByTime(timeStart, timeEnd);
    }

    /**
     * resMngRecordInfoDao use
     */

    /**
     * <p>Description: 通过项目获取用户名信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param timeStart, timeEnd, project
     * @return java.util.List<java.lang.String>
     * @throws
     */
    public List<String> getPersonNameByProject(String timeStart, String timeEnd, String project) {
        return resMngRecordInfoDao.getPersonNameByProject(timeStart, timeEnd, project);
    }

    /**
     * <p>Description: 获取用户信息表基本信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.ResMngRecordInfo>
     * @throws
     */
    public List<ResMngRecordInfo> findUserGroupDeptInfo() {
        return resMngRecordInfoDao.findUserGroupDeptInfo();
    }

    /**
     * <p>Description: 获取平台信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.ResMngRecordInfo>
     * @throws
     */
    public List<ResMngRecordInfo> getPatformResRecord() {
        return resMngRecordInfoDao.findPatformResRecord();
    }

    /**
     * qualificationDao use
     */

    /**
     * <p>Description: 根据部门来获取资质信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param dept
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    public List<Qualification> getQualificationByDept(String dept) {
        return qualificationDao.getQualificationByDept(dept);
    }

    /**
     * <p>Description: 根据小组来获取资质信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param dept, group
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    public List<Qualification> getQualificationByGroup(String dept, String group) {
        return qualificationDao.getQualificationByGroup(dept, group);
    }

    /**
     * <p>Description: 根据用户名来获取资质信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param dept, group, name
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    public List<Qualification> getQualificationByUserName(String dept, String group, String name) {
        return qualificationDao.getQualificationByUserName(dept, group, name);
    }

    /**
     * <p>Description: 获取所有资质信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param
     * @return java.util.List<com.ruijie.rgcc.entity.Qualification>
     * @throws
     */
    public List<Qualification> getAllQualification() {
        return qualificationDao.getAllQualification();
    }

    /**
     * <p>Description: 更新资质信息</p>
     * <p>Create Time: 2018/6/9 </p>
     * @author zhengchengbin
     * @param qualification
     * @return boolean
     * @throws
     */
    public boolean updateQualification(Qualification qualification) {
        return qualificationDao.updateQualification(qualification);
    }

}

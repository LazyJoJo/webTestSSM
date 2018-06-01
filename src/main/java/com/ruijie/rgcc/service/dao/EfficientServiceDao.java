package com.ruijie.rgcc.service.dao;

import com.ruijie.rgcc.dao.CafCodeInfoDao;
import com.ruijie.rgcc.dao.QualificationDao;
import com.ruijie.rgcc.dao.ResMngRecordInfoDao;
import com.ruijie.rgcc.dao.SvnMessageDao;
import com.ruijie.rgcc.entity.*;

import javax.annotation.Resource;
import java.util.List;

public class EfficientServiceDao {
    @Resource
    private QualificationDao qualificationDao;
    @Resource
    private ResMngRecordInfoDao resMngRecordInfoDao;
    @Resource
    private SvnMessageDao svnMessageDao;
    @Resource
    private CafCodeInfoDao cafCodeInfoDao;


    /**
     * svnMessageDao use
     */


    public List<SvnMessage> getCodeLineBySvn(String timeS, String timeE) {
        return svnMessageDao.getSvnMessageByTime(timeS, timeE);
    }


    /**
     * cafCodeInfoDao use
     */

    public List<CafCodeInfo> getCodeInfoByTime(String timeS, String timeE) {
        return cafCodeInfoDao.getCodeInfoByTime(timeS, timeE);
    }

    /**
     * resMngRecordInfoDao use
     */

    public List<String> getPersonNameByProject(String timeS, String timeE, String project) {
        return resMngRecordInfoDao.getPersonNameByProject(timeS, timeE, project);
    }

    public List<ResMngRecordInfo> findUserGroupDeptInfo() {
        return resMngRecordInfoDao.findUserGroupDeptInfo();
    }

    public List<ResMngRecordInfo> getPatformResRecord() {
        return resMngRecordInfoDao.findPatformResRecord();
    }

    /**
     * qualificationDao use
     */

    public List<Qualification> getQualificationByDept(String dept) {
        return qualificationDao.getQualificationByDept(dept);
    }

    public List<Qualification> getQualificationByGroup(String dept, String group) {
        return qualificationDao.getQualificationByGroup(dept, group);
    }

    public List<Qualification> getQualificationByUserName(String dept, String group, String name) {
        return qualificationDao.getQualificationByUserName(dept, group, name);
    }

    public List<Qualification> getAllQualification() {
        return qualificationDao.getAllQualification();
    }

    public boolean updateQualification(Qualification qualification) {
        return qualificationDao.updateQualification(qualification);
    }

    public List<Qualification> findAll() {
        return qualificationDao.findAll();
    }
}

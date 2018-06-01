package com.ruijie.rgcc.inter;

import com.ruijie.rgcc.entity.CafCodeInfo;
import com.ruijie.rgcc.entity.Qualification;
import com.ruijie.rgcc.entity.ResMngRecordInfo;
import com.ruijie.rgcc.entity.SvnMessage;
import com.ruijie.rgcc.entity.EasyuiResult;

import net.sf.json.JSONObject;

import java.util.List;

public interface EfficientService {
    List<Qualification> getAll();

    List<ResMngRecordInfo> findUserGroupDeptInfo();

    List<ResMngRecordInfo> getPatformResRecord();

    List<JSONObject> getCodeLineInfo(String querytype, ResMngRecordInfo resMngRecordInfo);

    List<CafCodeInfo> getEachPersonByProject(String timeS, String timeE, String project);

    List<SvnMessage> getCodeLineBySvn(String timeS, String timeE, String type);

    String updateQualification(Qualification qualification);

    EasyuiResult getQualification(String dept, String group, String username, String type, int pageSize, int pageNum);
}

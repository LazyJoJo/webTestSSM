package com.ruijie.rgcc.inter;

import com.ruijie.rgcc.entity.CafCodeInfo;
import com.ruijie.rgcc.entity.Qualification;
import com.ruijie.rgcc.entity.ResMngRecordInfo;
import com.ruijie.rgcc.entity.SvnMessage;
import com.ruijie.rgcc.entity.EasyuiResult;

import net.sf.json.JSONObject;

import java.util.List;
/**
 * <p>Title: EfficientService </p>
 * <p>Description: EfficientService 接口类</p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/6/3 </p>
 *
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public interface EfficientService {

    public List<Qualification> getAll();

    public List<ResMngRecordInfo> findUserGroupDeptInfo();

    public List<JSONObject> getCodeLineInfo(String queryType, ResMngRecordInfo resMngRecordInfo);

    public List<CafCodeInfo> getEachPersonByProject(String timeStart, String timeEnd, String project);

    public List<SvnMessage> getCodeLineBySvn(String timeStart, String timeEnd, String type);

    public String updateQualification(Qualification qualification);

    public EasyuiResult getQualification(String dept, String group, String userName, String type,
                                         int pageSize, int pageNum);
}

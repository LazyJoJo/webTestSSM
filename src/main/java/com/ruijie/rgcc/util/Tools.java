package com.ruijie.rgcc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * <p>Title: Tools </p>
 * <p>Description: 工具类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/28 </p>
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public class Tools {
    /**
     * <p>Description: 字符时间大小比较</p>
     * <p>Create Time: 2018/5/30 </p>
     * @author zhengchengbin
     * @param applyTime, timeStart, timeEnd
     * @return boolean
     * @throws
     */
    public static boolean timeCompare(String applyTime, String timeStart, String timeEnd) {
        boolean flag = false;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");;
        try {
            Date appTime = simpleDateFormat.parse(applyTime.toString());
            Date dateStartTmp = simpleDateFormat.parse(timeStart.toString());
            Date dateEndTmp= simpleDateFormat.parse(timeEnd.toString());
            if (appTime.getTime() >=dateStartTmp.getTime() && appTime.getTime() <= dateEndTmp.getTime()) {
                flag = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (flag) {
            return true;
        } else {
            return false;
        }
    }
}

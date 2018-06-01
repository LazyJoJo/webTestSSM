package com.ruijie.rgcc.entity;

import java.util.List;
/**
 * <p>Title: EasyuiResult </p>
 * <p>Description: 前端所需数据封装类 </p>
 * <p>Copyright: Copyright (c) 2018 </p>
 * <p>Company: Ruijie Co., Ltd. </p>
 * <p>Create Time: 2018/5/23 </p>
 * @author zhengchengbin
 * <p>Update Time: </p>
 * <p>Updater: </p>
 * <p>Update Comments: </p>
 */
public class EasyuiResult {
    /**
     * 所需结果总条数
     */
    private long total;

    /**
     * 所需结果集
     */
    private List<?> rows;

    /**
     * getter and setter
     */
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

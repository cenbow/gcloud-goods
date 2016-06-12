package com.gcloud.goods.dao;

import com.gcloud.goods.domain.Area;

import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaDaoImpl
 * @Package com.gcloud.api
 * @Description: 地址IDao
 * @date 2016/6/1 13:53
 */
public interface IAreaDao {

    /**
     * 查询所有地址
     * @param condition
     * @return
     */
    public List<Area> queryAreaList(Map<String, Object> condition);

}

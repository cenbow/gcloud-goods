package com.gcloud.goods.core;

import com.gcloud.goods.domain.Area;

import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaServiceImpl
 * @Package com.gcloud.api
 * @Description: 地址IService
 * @date 2016/6/1 13:53
 */
public interface IAreaService {

    /**
     * 查询所有地址
     * @param condition
     * @return
     */
    public List<Area> queryAreaList(Map<String, Object> condition);
}

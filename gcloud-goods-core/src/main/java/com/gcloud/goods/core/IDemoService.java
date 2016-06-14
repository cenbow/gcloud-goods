package com.gcloud.goods.core;

import com.gcloud.goods.domain.Demo;

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
public interface IDemoService {

    /**
     * 查询所有地址
     * @param condition
     * @return
     */
    public List<Demo> queryDemoList(Map<String, Object> condition);

}

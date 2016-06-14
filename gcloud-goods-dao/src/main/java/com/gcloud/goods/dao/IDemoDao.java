package com.gcloud.goods.dao;

import com.gcloud.goods.domain.Demo;

import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: IDemoDao
 * @Package com.gcloud.goods.dao
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/14 10:27
 */
public interface IDemoDao {

    /**
     * 查询所有地址
     * @param condition
     * @return
     */
    public List<Demo> queryDemoList(Map<String, Object> condition);
}

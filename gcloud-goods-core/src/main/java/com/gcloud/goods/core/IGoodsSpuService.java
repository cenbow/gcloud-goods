package com.gcloud.goods.core;

import com.gcloud.goods.domain.GoodsSpu;

import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: IGoodsSpuService
 * @Package com.gcloud.goods.core
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/8/11 14:28
 */
public interface IGoodsSpuService {

    int deleteByPrimayKey(Long spuId) throws ServcieException;

    int insert(GoodsSpu record) throws ServcieException;

    int insertSelective(GoodsSpu record) throws ServcieException;

    GoodsSpu selectByPrimaryKey(Long spuId) throws ServcieException;

    int updateByPrimaryKeySelective(GoodsSpu record) throws ServcieException;

    int updateByPrimaryKey(GoodsSpu record) throws ServcieException;

    /**
     * 查询商品SPU信息
     * @param params
     * @return
     */
    List<GoodsSpu> queryGoodsSpu(Map<String, Object> params) throws ServcieException;

}

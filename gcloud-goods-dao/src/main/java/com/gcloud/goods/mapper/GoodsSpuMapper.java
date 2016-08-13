package com.gcloud.goods.mapper;

import com.gcloud.goods.domain.GoodsSpu;

import java.util.List;
import java.util.Map;

public interface GoodsSpuMapper {
    int deleteByPrimaryKey(Long goodsSpu);

    int insert(GoodsSpu record);

    int insertSelective(GoodsSpu record);

    GoodsSpu selectByPrimaryKey(Long goodsSpu);

    int updateByPrimaryKeySelective(GoodsSpu record);

    int updateByPrimaryKey(GoodsSpu record);

    /**
     * 查询商品SPU信息
     * @param params
     * @return
     */
    List<GoodsSpu> queryGoodsSpu(Map<String, Object> params);

}
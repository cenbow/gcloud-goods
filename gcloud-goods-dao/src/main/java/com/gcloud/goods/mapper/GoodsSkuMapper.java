package com.gcloud.goods.mapper;

import com.gcloud.goods.domain.GoodsSku;

import java.util.List;
import java.util.Map;

public interface GoodsSkuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsSku record);

    int insertSelective(GoodsSku record);

    GoodsSku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsSku record);

    int updateByPrimaryKey(GoodsSku record);

    /**
     * 查询SKU数据
     * @param params
     * @return
     */
    List<GoodsSku> queryGoodsSku(Map<String, Object> params);
}
package com.gcloud.goods.mapper;

import com.gcloud.goods.domain.Trade;

public interface TradeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);
}
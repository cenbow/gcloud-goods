package com.gcloud.goods.core.impl;

import com.gcloud.goods.core.ITradeService;
import com.gcloud.goods.core.ServcieException;
import com.gcloud.goods.domain.Trade;
import com.gcloud.goods.mapper.TradeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GoodsSpuServiceImpl
 * @Package com.gcloud.goods.core.impl
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/8/11 14:29
 */
@Service("tradeService")
public class TradeServiceImpl implements ITradeService {

    @Resource
    private TradeMapper tradeMapper;

    @Override
    public int deleteByPrimaryKey(Long aLong) throws ServcieException {
        return tradeMapper.deleteByPrimaryKey(aLong);
    }

    @Override
    public int insert(Trade trade) throws ServcieException {
        return tradeMapper.insert(trade);
    }

    @Override
    public int insertSelective(Trade trade) throws ServcieException {
        return tradeMapper.insertSelective(trade);
    }

    @Override
    public Trade selectByPrimaryKey(Long aLong) throws ServcieException {
        return tradeMapper.selectByPrimaryKey(aLong);
    }

    @Override
    public int updateByPrimaryKeySelective(Trade trade) throws ServcieException {
        return tradeMapper.updateByPrimaryKeySelective(trade);
    }

    @Override
    public int updateByPrimaryKey(Trade trade) throws ServcieException {
        return tradeMapper.updateByPrimaryKey(trade);
    }
}

package com.gcloud.goods.core;

import com.gcloud.goods.domain.Trade;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: IGoodsSpuService
 * @Package com.gcloud.goods.core
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/8/11 14:28
 */
public interface ITradeService {

    int deleteByPrimaryKey(Long id) throws ServcieException;

    int insert(Trade record) throws ServcieException;

    int insertSelective(Trade record) throws ServcieException;

    Trade selectByPrimaryKey(Long id) throws ServcieException;

    int updateByPrimaryKeySelective(Trade record) throws ServcieException;

    int updateByPrimaryKey(Trade record) throws ServcieException;

}

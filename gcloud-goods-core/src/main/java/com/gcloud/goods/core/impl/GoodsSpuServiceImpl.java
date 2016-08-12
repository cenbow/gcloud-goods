package com.gcloud.goods.core.impl;

import com.gcloud.goods.core.Constant;
import com.gcloud.goods.core.IGoodsSpuService;
import com.gcloud.goods.core.ServcieException;
import com.gcloud.goods.mapper.GoodsSpuMapper;
import com.gcloud.goods.domain.GoodsSpu;
import com.gcloud.goods.solr.SolrUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GoodsSpuServiceImpl
 * @Package com.gcloud.goods.core.impl
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/8/11 14:29
 */
@Service("goodsSpuService")
public class GoodsSpuServiceImpl implements IGoodsSpuService {

    private static final Logger logger = LogManager.getLogger(GoodsSpuServiceImpl.class);

    @Resource
    private GoodsSpuMapper goodsSpuMapper;

    @Resource
    HttpSolrClient solrClient;

    @Override
    public int deleteByPrimayKey(Long spuId) throws ServcieException {
        return goodsSpuMapper.deleteByPrimaryKey(spuId);
    }

    @Override
    public int insert(GoodsSpu record) throws ServcieException {
        return goodsSpuMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsSpu record) throws ServcieException {
        return goodsSpuMapper.insertSelective(record);
    }

    @Override
    public GoodsSpu selectByPrimaryKey(Long spuId) throws ServcieException {
        return goodsSpuMapper.selectByPrimaryKey(spuId);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsSpu record) throws ServcieException {
        return goodsSpuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsSpu record) throws ServcieException {
        return goodsSpuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsSpu> queryGoodsSpu(Map<String, Object> params) throws ServcieException {

        List<GoodsSpu> goodsSpuList = null;
        try{

            goodsSpuList = goodsSpuMapper.queryGoodsSpu(params);
            List<SolrInputDocument> solrInputDocumentList = SolrUtil.getInstance().getSolrInputDocument(goodsSpuList);
            SolrUtil.getInstance().addSolrDoc(solrClient, solrInputDocumentList);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServcieException(Constant.API_CALL_ERROR, "查询商品SPU出错!");
        }
        return goodsSpuList;
    }

}

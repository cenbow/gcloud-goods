package com.gcloud.goods.solr;

import com.gcloud.goods.domain.GoodsSpu;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Solr 操作工具类(单例模式)
 * Created by janenone on 2016/1/31.
 */
public class SolrCouldUtil {

    private static final String SOLR_URL = "http://192.168.180.128:8080/solr/gshop";

    private static SolrCouldUtil solrUtil;

    private static CloudSolrClient cloudSolrClient;

    private SolrCouldUtil(){

    }

    /**
     * 实例化当前类
     * @return
     */
    public static SolrCouldUtil getInstance(){
        if(null == solrUtil){
            solrUtil = new SolrCouldUtil();
            cloudSolrClient = new CloudSolrClient(SOLR_URL);
        }
        return solrUtil;
    }

    /**
     * Solr查询
     * @param solrParam
     * @return
     */
    public static QueryResponse query(Map<String, String> solrParam){

        QueryResponse queryResponse = null;
        try {
            getInstance();
            solrParam.put("q", " *:* ");
            solrParam.put("start", String.valueOf(1));
            solrParam.put("rows",  String.valueOf(100));
            SolrParams solrParams = initSolrParams(solrParam);
            queryResponse = cloudSolrClient.query(solrParams);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return queryResponse;
    }

    /**
     * 初始化Solr参数
     * @param paramMap
     * @return
     */
    public static SolrParams initSolrParams(Map<String, String> paramMap){
        return new MapSolrParams(paramMap);
    }

    /**
     * 创建索引
     * @param param
     * @return
     */
    public static int delSolrDocByQuery(Map<String, Object> param){
        int delSize =0;
        try {
            getInstance();
            cloudSolrClient.deleteByQuery(null);
            cloudSolrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return delSize;
    }

    /**
     * 创建索引
     * @param idList
     * @return
     */
    public static int delSolrDocById(List<String> idList){
        int delSize =0;
        try {
            getInstance();
            cloudSolrClient.deleteById(idList);
            cloudSolrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return delSize;
    }

    /**
     * 创建索引
     * @param goodsSpuList
     * @return
     */
    public static int addSolrDoc(List<GoodsSpu> goodsSpuList){

        int addSize =0;
        try {
            getInstance();
            for(GoodsSpu goodsSpu : goodsSpuList) {

                SolrInputDocument solrInputDocument = new SolrInputDocument();
                solrInputDocument.addField("id", goodsSpu.getId());
                solrInputDocument.addField("area_id", goodsSpu.getId());
                solrInputDocument.addField("area_name", goodsSpu.getGoodsName());
                solrInputDocument.addField("area_type", 0);
                solrInputDocument.addField("area_parent_id", goodsSpu.getPropsName());
                solrInputDocument.addField("area_zip", goodsSpu.getBarcode());
                cloudSolrClient.add(solrInputDocument);
                addSize ++;
            }
            cloudSolrClient.optimize();
            cloudSolrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addSize;
    }
}

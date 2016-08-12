package com.gcloud.goods.solr;

import com.gcloud.goods.domain.GoodsSpu;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Solr 操作工具类(单例模式)
 * Created by janenone on 2016/1/31.
 */
public class SolrUtil {

    private static final String SOLR_URL = "http://127.0.0.1:8080/solr/gcloud_goods";

    private static SolrUtil solrUtil;

    private static SolrClient solrClient;

    private SolrUtil(){

    }

    /**
     * 实例化当前类
     * @return
     */
    public static SolrUtil getInstance(){
        if(null == solrUtil){
            solrUtil = new SolrUtil();
            solrClient = new HttpSolrClient(SOLR_URL);
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
            queryResponse = solrClient.query(solrParams);
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
            solrClient.deleteByQuery(null);
            solrClient.commit();
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
            solrClient.deleteById(idList);
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return delSize;
    }

    /**
     * 创建索引
     * @param solrInputDocumentList
     * @return
     */
    public static int addSolrDoc(List<SolrInputDocument> solrInputDocumentList){

        int addSize =0;
        try {
            getInstance();
            solrClient.add(solrInputDocumentList);
            solrClient.optimize();
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addSize;
    }

    /**
     *
     * @param solrServer
     * @param solrInputDocumentList
     * @return
     */
    public static void addSolrDoc(HttpSolrServer solrServer, List<SolrInputDocument> solrInputDocumentList){

        try {
            for(SolrInputDocument solrInputDocument : solrInputDocumentList){
                solrServer.add(solrInputDocument);
            }
            solrServer.optimize();
            solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SolrInputDocument> getSolrInputDocument(List<GoodsSpu> goodsSpuList){

        List<SolrInputDocument> solrInputDocumentList = new ArrayList<SolrInputDocument>();
        for(GoodsSpu goodsSpu : goodsSpuList) {
            SolrInputDocument solrInputDocument = new SolrInputDocument();
            solrInputDocument.addField("id", goodsSpu.getId());
            solrInputDocument.addField("area_id", goodsSpu.getId());
            solrInputDocument.addField("area_name", goodsSpu.getPicPath());
            solrInputDocument.addField("area_type", goodsSpu.getAge());
            solrInputDocument.addField("area_parent_id", goodsSpu.getPropsName());
            solrInputDocument.addField("area_zip", goodsSpu.getBarcode());
            solrInputDocumentList.add(solrInputDocument);
        }
        return solrInputDocumentList;
    }
}

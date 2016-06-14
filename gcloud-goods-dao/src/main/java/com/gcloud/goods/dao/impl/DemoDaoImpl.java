package com.gcloud.goods.dao.impl;

import com.gcloud.goods.dao.IDemoDao;
import com.gcloud.goods.domain.Demo;
import com.gcloud.goods.domain.Page;
import org.apache.commons.collections.MapUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: DemoDaoImpl
 * @Package com.gcloud.goods.dao.impl
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/14 10:30
 */
@Repository("demoDao")
public class DemoDaoImpl implements IDemoDao {

    private static final Logger log = LogManager.getLogger(DemoDaoImpl.class);

    @Resource
    SqlSessionFactory sessionFactory;

    @Override
    public List<Demo> queryDemoList(Map<String, Object> condition) {

        if (null == MapUtils.getString(condition, "startRow")) {
            condition.put("startRow", new Page().getStartRow());
            condition.put("offsetRow", new Page().getOffsetRow());
        }
        log.info("===================== queryAreaList ==============================");
        return sessionFactory.openSession().selectList("Demo.queryDemoList", condition);
    }
}

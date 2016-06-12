package com.gcloud.goods.dao.impl;

import com.gcloud.goods.dao.IAreaDao;
import com.gcloud.goods.domain.Area;
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
 * @Title: AreaDaoImpl
 * @Package com.gcloud.api
 * @Description: 地址Dao
 * @date 2016/6/1 13:53
 */
@Repository("areaDao")
public class AreaDaoImpl implements IAreaDao {

    private static final Logger log = LogManager.getLogger(AreaDaoImpl.class);

    @Resource
    SqlSessionFactory sessionFactory;

    @Override
    public List<Area> queryAreaList(Map<String, Object> condition) {

        if( null == MapUtils.getString(condition, "startRow")){
            condition.put("startRow", new Page().getStartRow());
            condition.put("offsetRow", new Page().getOffsetRow());
        }
        log.info("===================== queryAreaList ==============================");
        return sessionFactory.openSession().selectList("Area.queryAreaList", condition);
    }
}

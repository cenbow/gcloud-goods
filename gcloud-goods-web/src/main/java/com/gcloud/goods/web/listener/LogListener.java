package com.gcloud.goods.web.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: LogListener
 * @Package com.gcloud.shop.web.listener
 * @Description: Log监听器
 * @date 2016/5/31 17:36
 */
public class LogListener implements ServletContextListener {

    private static final Logger log = LogManager.getLogger(LogListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("=============== contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("--------------- contextDestroyed");
    }

}

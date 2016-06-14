package com.gcloud.goods.web.controller;


import com.gcloud.event.core.EventInfo;
import com.gcloud.event.core.IEventCenter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaController
 * @Package com.gcloud.demo.web.controller
 * @Description: 地区信息
 * @date 2016/6/1 13:53
 */
@Controller
@RequestMapping("/data/area")
public class AreaController {

    private static final Logger logger = LogManager.getLogger(AreaController.class);

    @Resource
    private IEventCenter eventCenter;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response) {
        eventCenter.fireEvent(this, new EventInfo("gcloud_goods_area_list").setArgs(new Object[]{"ChenJin"}), null);
        return null;
    }

}
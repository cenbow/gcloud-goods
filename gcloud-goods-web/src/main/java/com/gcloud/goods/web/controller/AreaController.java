package com.gcloud.goods.web.controller;


import com.gcloud.goods.core.IAreaService;
import com.gcloud.goods.domain.Area;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 地区信息
 * @author chenjin
 * @since 2015年11月22日 上午11:35:28
 **/

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

    @Autowired
    IAreaService areaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response) {

        List<Area> areaList =areaService.queryAreaList(new HashMap<String, Object>());
        logger.info(areaList.size());
        return areaList;
    }

}
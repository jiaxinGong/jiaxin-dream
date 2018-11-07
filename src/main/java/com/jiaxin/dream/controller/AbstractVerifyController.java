package com.jiaxin.dream.controller;

import com.jiaxin.dream.exception.CheckException;
import com.jiaxin.dream.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 验证相关
 * @author: gongjiaxin
 * @create: 2018-04-27 10:40
 **/
public abstract class AbstractVerifyController {

    Logger logger = LoggerFactory.getLogger(AbstractVerifyController.class);
    /**
     * 白名单校验
     * @param request
     * @throws Exception
     */
    @ModelAttribute
    public void checkWhiteList(HttpServletRequest request) throws Exception {
        // 白名单
        List<String> whiteList = new ArrayList<>();
        whiteList.add("127.0.0.1");
        whiteList.add("192.168.190.178");
        String ip = IPUtil.getIpAddr(request);
        if (whiteList.contains(ip)) {
            // ignore
        } else {
            // 非法请求
            throw new CheckException("非法请求,请求ip->"+ip);
        }

    }
}

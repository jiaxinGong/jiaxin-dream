package com.jiaxin.dream.controller;/**
 * @Author: bufoon
 * @Email: song.anling@zyxr.com
 * @Datetime: Created In 2018/4/27 10:40
 * @Desc: as follows.
 */

import com.jiaxin.dream.utils.IPUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 验证相关
 * @author: gongjiaxin
 * @create: 2018-04-27 10:40
 **/
public abstract class AbstractVerifyController {
    public void checkWhiteList(HttpServletRequest request) throws Exception {
        // 白名单
        List<String> whiteList = new ArrayList<>();
        whiteList.add("127.0.0.1");
        String ip = IPUtil.getIpAddr(request);
        if (whiteList.contains(ip)) {
            // ignore
        } else {
            // 非法请求
            throw new Exception("非法请求");
        }

    }
}

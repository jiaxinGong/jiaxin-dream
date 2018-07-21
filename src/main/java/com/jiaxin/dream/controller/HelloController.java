package com.jiaxin.dream.controller;

import com.jiaxin.dream.model.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController extends AbstractVerifyController{

    @RequestMapping("/hello")
    @ResponseBody
    public ResultBean<Map> sysHello(){
        Map<String,Object> map = new HashMap<>();
        map.put("a","a1");
        map.put("b","b1");
        map.put("c","c1");
        int i = 10/0;

        ResultBean resultBean = new ResultBean(map);
        return resultBean;
    }
}

package com.jiaxin.dream.controller;

import com.jiaxin.dream.common.AbstractHelpController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController extends AbstractHelpController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sysHello(){
        return "hello.2018.04.26";
    }
}

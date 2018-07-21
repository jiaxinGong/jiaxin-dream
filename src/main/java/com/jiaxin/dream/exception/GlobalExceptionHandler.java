package com.jiaxin.dream.exception;/**
 * @Author: jiaxin Gong
 * @Email: gong.jiaxin@szrttx.com
 * @Datetime: Created In 2018/4/27 16:36
 * @Desc: as follows.
 */

import com.alibaba.fastjson.JSON;
import com.jiaxin.dream.model.ResultBean;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 全局异常处理
 * @author: gongjiaxin
 * @create: 2018-04-27 16:36
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    @ResponseBody
    public Object doHandler(HttpServletRequest request, Exception e) {
        ResultBean<String> result = new ResultBean<>();
        result.setCode(ResultBean.FAIL);
        if (e instanceof CheckException) {
            result.setMsg(((CheckException) e).getDesc());
        } else {
            result.setMsg(e.toString());
            // 邮件处理等 TODO
        }
        logger.error("Global Exception: {} \n belows \n {}", JSON.toJSONString(result), ExceptionUtils.getStackTrace(e));
        return result;
    }
}

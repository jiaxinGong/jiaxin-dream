package com.jiaxin.dream.aop;/**
 * @Author: jiaxin Gong
 * @Email: gong.jiaxin@szrttx.com
 * @Datetime: Created In 2018/4/28 14:04
 * @Desc: as follows.
 */

import com.jiaxin.dream.exception.CheckException;
import com.jiaxin.dream.model.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: gongjiaxin
 * @create: 2018-04-28 14:04
 **/
public class ControllerAOP {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

    /**
     * 切面处理，异常统一由全局异常处理器处理
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;

//        try {
        result = (ResultBean<?>) pjp.proceed();
        logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
//        } catch (Throwable e) {
//            result = handlerException(pjp, e);
//        }

        return result;
    }

    /**
     * 异常处理
     *
     * @param pjp
     * @param e
     * @return
     */
    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();

        // 已知异常
        if (e instanceof CheckException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        } else {
            logger.error(pjp.getSignature() + " error ", e);

            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);

            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
        }

        return result;
    }
}

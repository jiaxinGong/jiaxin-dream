package com.jiaxin.dream.aop2;
/**
 * @Author: jiaxin Gong
 * @Email: gong.jiaxin@szrttx.com
 * @Datetime: Created In 2018/5/15 15:22
 * @Desc: as follows.
 */

//import com.rttx.mobile.base.constant.Constants;
//import com.rttx.mobile.common.IZooKeeperConfig;
//import com.rttx.risk.commons.base.ResEnum;
//import com.rttx.risk.commons.utils.StringUtils;
//import com.rttx.risk.gateway.base.OpenApiResponse;
//import com.rttx.risk.gateway.constants.ZKConstant;
//import com.rttx.risk.gateway.support.FastJsonModerAndView;
import com.jiaxin.dream.utils.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 供测试环境使用的挡板类
 * @author: gongjiaxin
 * @create: 2018-05-15 15:22
 **/
@Conditional(SITAopCondition.class)
@Aspect
@Component
public class SITAopController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    // 挡板配置
    AtomicReference<String> BAFFLE_CONFIG = new AtomicReference<>("null");
    private String BAFFLE_PATH = "/val";

    @Autowired
//    private IZooKeeperConfig zkConfig;

    @PostConstruct
    public void init() {
//        BAFFLE_CONFIG.set(zkConfig.get(BAFFLE_PATH));
//        zkConfig.dataChanges(BAFFLE_PATH, BAFFLE_CONFIG, "");
    }

    // ΩДΩ ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓准入规则↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    @Pointcut("execution(public * com.jiaxin.dream.controller.HelloController.sysHello(..))")
    public void accessRulePoint() {
    }

    @Around("accessRulePoint()")
    public Object accessRuleAround(ProceedingJoinPoint pjp) {
        logger.info("=================accessRulePanelPoint==================");
        String valveConfigJsonStr = BAFFLE_CONFIG.get();

        if (StringUtils.isNotEmpty(valveConfigJsonStr)) {
            Object result = null;
            try {
                result = pjp.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return result;
        } else {
            return null;
//            return new FastJsonModerAndView(new OpenApiResponse<String>(ResEnum.SUCCESS, ""));
        }
    }
    // ΩДΩ ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑准入规则↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


}

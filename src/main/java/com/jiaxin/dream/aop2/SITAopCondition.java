package com.jiaxin.dream.aop2;/**
 * @Author: jiaxin Gong
 * @Email: gong.jiaxin@szrttx.com
 * @Datetime: Created In 2018/5/15 16:24
 * @Desc: as follows.
 */

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @description:
 * @author: gongjiaxin
 * @create: 2018-05-15 16:24
 **/
public class SITAopCondition implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return "SIT".equals(System.getProperty("rttx.environment"));
    }
}

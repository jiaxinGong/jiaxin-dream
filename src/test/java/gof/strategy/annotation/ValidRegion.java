package gof.strategy.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRegion {

    int min() default Integer.MIN_VALUE;

    int max() default Integer.MAX_VALUE;

    int order() default 0;
}

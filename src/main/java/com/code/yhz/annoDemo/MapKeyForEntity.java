package com.code.yhz.annoDemo;

import java.lang.annotation.*;

/**
 * 实体类中对应的map中的字段名
 * @Author yhz
 * @Date 2020/9/11 11:41
 */
@Target ( ElementType.FIELD )
@Retention ( RetentionPolicy.RUNTIME )
@Documented
public @interface MapKeyForEntity {
    String value() default "";
}

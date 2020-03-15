package com.forever.zhb.common.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD,TYPE})
@Retention(RUNTIME)
public @interface Info {
    
    String value() default "zhanghuibin";
    boolean isDelete();

}

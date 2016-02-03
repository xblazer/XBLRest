package com.xblazer.core.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
public @interface NotRequireLogin {
    boolean value() default true;
}

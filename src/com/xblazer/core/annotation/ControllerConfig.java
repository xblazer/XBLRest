package com.xblazer.core.annotation;

import java.lang.annotation.*;

/**
 * @author NCIT
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface ControllerConfig {

	String[] key();

}

package com.lanle.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface LanAnnotation {

    public String remark() default "";
    public boolean show() default true;
}

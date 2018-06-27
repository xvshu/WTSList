package com.xs.java.dbs.utils.annotation;

import java.lang.annotation.*;

/**
 * 表名注释
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableAnnotation {
    String tableName();
}

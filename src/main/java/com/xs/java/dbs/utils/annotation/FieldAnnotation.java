package com.xs.java.dbs.utils.annotation;

import java.lang.annotation.*;


/**
 * 字段注释
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAnnotation {
    /**
     * 字段名
     * @return
     */
    String fieldName();

    /**
     * 字段类型
     * @return
     */
    FieldType fieldType();

    /**
     * 是否是主键
     * @return
     */
    boolean pk();
}

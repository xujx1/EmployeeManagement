package com.architecture.em.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 读写分离部分，只读数据源选择注解
 * Created by xujinxin on 2017/2/22.
 */
@Target(ElementType.METHOD)
public @interface ReadOnly {
}

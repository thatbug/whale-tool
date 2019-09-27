package org.thatbug.whale.core.secure.annotation;

import java.lang.annotation.*;

/**
 * 权限注解 用于检查权限
 *
 * @author qzl
 * @date 15:50 2019/9/17
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PreAuth {

    /**
     * Spring el
     * 文档地址：https://docs.spring.io/spring/docs/4.3.16.RELEASE/spring-framework-reference/htmlsingle/#expressions-operators-logical
     */
    String value();

}

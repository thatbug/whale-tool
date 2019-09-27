package org.thatbug.whale.core.boot.tenant;

/**
 * 租户id生成器
 *
 * @author qzl
 * @date 17:53 2019/9/19
 */
public interface TenantId {

    /**
     * 生成自定义租户id
     *
     * @return string
     */
    String generate();

}
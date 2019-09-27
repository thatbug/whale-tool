package org.thatbug.whale.core.boot.tenant;

import org.thatbug.whale.core.tool.utils.RandomType;
import org.thatbug.whale.core.tool.utils.StringUtil;

/**
 * 租户id生成器
 *
 * @author qzl
 * @date 17:51 2019/9/19
 */
public class WhaleTenantId implements TenantId {
    @Override
    public String generate() {
        return StringUtil.random(6, RandomType.INT);
    }
}


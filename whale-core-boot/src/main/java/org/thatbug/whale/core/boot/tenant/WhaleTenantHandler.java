package org.thatbug.whale.core.boot.tenant;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.thatbug.whale.core.secure.utils.SecureUtil;
import org.thatbug.whale.core.tool.utils.Func;
import org.thatbug.whale.core.tool.utils.StringUtil;

/**
 * 租户信息处理器
 *
 * @author qzl
 * @date 17:50 2019/9/19
 */
@Slf4j
@AllArgsConstructor
public class WhaleTenantHandler implements TenantHandler {

    private final WhaleTenantProperties properties;

    /**
     * 获取租户ID
     *
     * @return 租户ID
     */
    @Override
    public Expression getTenantId() {
        return new StringValue(Func.toStr(StringUtil.isEmpty(SecureUtil.getTenantId())?null:SecureUtil.getTenantId(), TenantConstant.DEFAULT_TENANT_ID));
    }

    /**
     * 获取租户字段名称
     *
     * @return 租户字段名称
     */
    @Override
    public String getTenantIdColumn() {
        return properties.getColumn();
    }

    /**
     * 过滤租户表
     *
     * @param tableName 表名
     * @return 是否进行过滤
     */
    @Override
    public boolean doTableFilter(String tableName) {
        return !(properties.getTables().contains(tableName) && !StringUtil.isEmpty(SecureUtil.getTenantId()));
    }
}


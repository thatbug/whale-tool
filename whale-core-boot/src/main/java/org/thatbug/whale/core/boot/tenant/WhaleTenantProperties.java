package org.thatbug.whale.core.boot.tenant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多租户配置
 *
 * @author qzl
 * @date 17:51 2019/9/19
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "whale.tenant")
public class WhaleTenantProperties {

    /**
     * 多租户字段名称
     */
    private String column = "tenant_id";

    /**
     * 多租户数据表
     */
    private List<String> tables = new ArrayList<>();

    /**
     * 多租户系统数据表
     */
    private List<String> bladeTables = Arrays.asList("whale_notice", "whale_log_api", "whale_log_error", "whale_log_usual");
}


package org.thatbug.whale.core.boot.tenant;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 多租户配置类
 *
 * @author qzl
 * @date 17:52 2019/9/19
 */
@Configuration
@AllArgsConstructor
@AutoConfigureBefore(MybatisConfiguration.class)
@EnableConfigurationProperties(WhaleTenantProperties.class)
public class TenantConfiguration {

    /**
     * 多租户配置类
     */
    private final WhaleTenantProperties properties;

    /**
     * 自定义租户处理器
     *
     * @return TenantHandler
     */
    @Bean
    @ConditionalOnMissingBean(TenantHandler.class)
    public TenantHandler bladeTenantHandler() {
        return new WhaleTenantHandler(properties);
    }


    @Bean
    public PaginationInterceptor paginationInterceptor(TenantHandler tenantHandler) {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new MyTenantSqlParser();
        tenantSqlParser.setTenantHandler(tenantHandler);
        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);

        return paginationInterceptor;
    }

}


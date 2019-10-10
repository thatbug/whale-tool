package org.thatbug.whale.core.secure.registry;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * api 放行配置
 *
 * @author qzl
 * @date 15:02 2019/9/17
 */
@Data
public class SecureRegistry {

    private boolean enable = true;

    private final List<String> defaultExcludePatterns = new ArrayList<>();

    private final List<String> excludePatterns = new ArrayList<>();

    public SecureRegistry() {
        this.defaultExcludePatterns.add("/doc.html");
        this.defaultExcludePatterns.add("/swagger-resources/**");
        this.defaultExcludePatterns.add("/v2/api-docs/**");
        this.defaultExcludePatterns.add("/v2/api-docs-ext/**");
        this.defaultExcludePatterns.add("/error/**");
        this.defaultExcludePatterns.add("/assets/**");
        this.defaultExcludePatterns.add("/webjars/**");
        this.defaultExcludePatterns.add("/swagger-resources/**");
    }

    /**
     * 设置放行api
     */
    public SecureRegistry excludePathPatterns(String... patterns) {
        return excludePathPatterns(Arrays.asList(patterns));
    }

    /**
     * 设置放行api
     */
    public SecureRegistry excludePathPatterns(List<String> patterns) {
        this.excludePatterns.addAll(patterns);
        return this;
    }

}

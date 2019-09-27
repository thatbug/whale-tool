package org.thatbug.whale.core.oss.config;

import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thatbug.whale.core.oss.QiniuTemplate;
import org.thatbug.whale.core.oss.props.OssProperties;
import org.thatbug.whale.core.oss.rule.OssRule;
import org.thatbug.whale.core.oss.rule.WhaleOssRule;

/**
 * oss配置类
 *
 * @author qzl
 * @date 17:20 2019/9/17
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(OssProperties.class)
@ConditionalOnProperty(value = "oss.enable", havingValue = "true")
public class OssConfiguration {

    private OssProperties ossProperties;

    @Bean
    @ConditionalOnMissingBean(OssRule.class)
    public OssRule ossRule() {
        return new WhaleOssRule();
    }

    @Bean
    public com.qiniu.storage.Configuration qiniuConfiguration() {
        return new com.qiniu.storage.Configuration(Zone.zone0());
    }

    @Bean
    public Auth auth() {
        return Auth.create(ossProperties.getAccessKey(), ossProperties.getSecretKey());
    }

    @Bean
    @ConditionalOnBean(com.qiniu.storage.Configuration.class)
    public UploadManager uploadManager(com.qiniu.storage.Configuration cfg) {
        return new UploadManager(cfg);
    }

    @Bean
    @ConditionalOnBean(com.qiniu.storage.Configuration.class)
    public BucketManager bucketManager(com.qiniu.storage.Configuration cfg) {
        return new BucketManager(auth(), cfg);
    }

    @Bean
    @ConditionalOnMissingBean(QiniuTemplate.class)
    @ConditionalOnBean({Auth.class, UploadManager.class, BucketManager.class, OssRule.class})
    public QiniuTemplate qiniuTemplate(Auth auth, UploadManager uploadManager, BucketManager bucketManager, OssRule ossRule) {
        return new QiniuTemplate(auth, uploadManager, bucketManager, ossProperties, ossRule);
    }


}


package org.thatbug.whale.core.oss.rule;

import lombok.AllArgsConstructor;
import org.thatbug.whale.core.tool.utils.DateUtil;
import org.thatbug.whale.core.tool.utils.FileUtil;
import org.thatbug.whale.core.tool.utils.StringPool;
import org.thatbug.whale.core.tool.utils.StringUtil;

/**
 * 默认存储桶生成规则
 *
 * @author qzl
 * @date 17:25 2019/9/17
 */
@AllArgsConstructor
public class WhaleOssRule implements OssRule {

    @Override
    public String bucketName(String bucketName) {
        return bucketName;
    }

    @Override
    public String fileName(String originalFilename) {
        return "upload" + StringPool.SLASH + DateUtil.today() + StringPool.SLASH + StringUtil.randomUUID() + StringPool.DOT + FileUtil.getFileExtension(originalFilename);
    }

}
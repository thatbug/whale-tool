package org.thatbug.whale.core.tool.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 森林节点类
 *
 * @author qzl
 * @date 14:51 2019/9/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ForestNode extends BaseNode {

    /**
     * 节点内容
     */
    private Object content;

    public ForestNode(Integer id, Integer parentId, Object content) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
    }

}
package org.thatbug.whale.core.tool.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 树型节点类
 *
 * @author qzl
 * @date 14:52 2019/9/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TreeNode extends BaseNode {

    private String title;

    private Integer key;

    private Integer value;

}
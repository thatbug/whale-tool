package org.thatbug.whale.core.tool.node;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点基类
 *
 * @author qzl
 * @date 14:51 2019/9/21
 */
@Data
public class BaseNode implements INode {

    /**
     * 主键ID
     */
    protected Integer id;

    /**
     * 父节点ID
     */
    protected Integer parentId;

    /**
     * 子孙节点
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected List<INode> children = new ArrayList<>();

}
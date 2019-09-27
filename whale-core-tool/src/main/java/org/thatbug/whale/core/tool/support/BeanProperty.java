package org.thatbug.whale.core.tool.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * BeanProperty
 *
 * @author qzl
 * @date 13:58 2019/9/17
 */
@Getter
@AllArgsConstructor
public class BeanProperty {
    private final String name;
    private final Class<?> type;
}

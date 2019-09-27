package org.thatbug.whale.core.mybatis.base;

import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 基础业务接口
 *
 * @author qzl
 * @date 18:49 2019/9/17
 */
public interface BaseService<T> extends IService<T> {

    /**
     * 逻辑删除
     *
     * @param ids id集合(逗号分隔)
     * @return
     */
    boolean deleteLogic(@NotEmpty List<Integer> ids);

}
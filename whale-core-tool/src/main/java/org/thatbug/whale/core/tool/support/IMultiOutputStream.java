package org.thatbug.whale.core.tool.support;

import java.io.OutputStream;

/**
 * IMultiOutputStream
 *
 * @author qzl
 * @date 17:42 2019/9/19
 */
public interface IMultiOutputStream {

    /**
     * Builds the output stream.
     *
     * @param params the params
     * @return the output stream
     */
    OutputStream buildOutputStream(Integer... params);

}

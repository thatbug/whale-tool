package org.thatbug.whale.core.boot.tenant;

import net.sf.jsqlparser.expression.operators.relational.Between;

/**
 * FIND_IN_SET
 *
 * @author qzl
 * @date 14:31 2019/11/4
 */
public class FindInSet extends Between {


    @Override
    public String toString() {
        String left=this.getBetweenExpressionStart().toString();
        String right = this.getBetweenExpressionEnd().toString();
        return "FIND_IN_SET(" + left + "," +right +")>0";
    }
}

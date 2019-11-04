package org.thatbug.whale.core.boot.tenant;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.SubSelect;

/**
 * TenantSqlParser
 *
 * @author qzl
 * @date 14:24 2019/11/4
 */
public class MyTenantSqlParser extends TenantSqlParser {
    @Override
    protected Expression builderExpression(Expression expression, Table table) {
        //生成字段名
        FindInSet findInSet = new FindInSet();
        findInSet.setBetweenExpressionStart(super.getTenantHandler().getTenantId());
        findInSet.setBetweenExpressionEnd(this.getAliasColumn(table));
        //加入判断防止条件为空时生成 "and null" 导致查询结果为空
        if (expression == null) {
            return findInSet;
        } else {
            if (expression instanceof BinaryExpression) {
                BinaryExpression binaryExpression = (BinaryExpression) expression;
                if (binaryExpression.getLeftExpression() instanceof FromItem) {
                    processFromItem((FromItem) binaryExpression.getLeftExpression());
                }
                if (binaryExpression.getRightExpression() instanceof FromItem) {
                    processFromItem((FromItem) binaryExpression.getRightExpression());
                }
            }
            if (expression instanceof OrExpression) {
                return new AndExpression(findInSet, new Parenthesis(expression));
            } else {
                // fix github 1201
                if (expression instanceof InExpression) {
                    InExpression inExp = (InExpression) expression;
                    ItemsList rightItems = inExp.getRightItemsList();
                    if (rightItems instanceof SubSelect) {
                        processSelectBody(((SubSelect) rightItems).getSelectBody());
                    }
                }
                return new AndExpression(findInSet, expression);
            }
        }
    }
}

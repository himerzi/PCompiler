
package ast.expressions; 

import ast.Visitor;

public class NotEqqExpr extends ExprNode {
	public NotEqqExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
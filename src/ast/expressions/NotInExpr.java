
package ast.expressions; 

import ast.Visitor;

public class NotInExpr extends ExprNode {
	public NotInExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
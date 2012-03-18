
package ast.expressions; 

import ast.Visitor;

public class EqqExpr extends ExprNode {
	public EqqExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
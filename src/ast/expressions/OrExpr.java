
package ast.expressions; 

import ast.Visitor;

public class OrExpr extends ExprNode {
	public OrExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
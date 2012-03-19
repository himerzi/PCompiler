
package ast.expressions; 

import visitor.Visitor;

public class GreaterEqExpr extends ExprNode {
	public GreaterEqExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
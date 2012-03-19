
package ast.expressions; 

import visitor.Visitor;

public class PowerExpr extends ExprNode {
	public PowerExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
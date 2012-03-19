
package ast.expressions; 

import visitor.Visitor;

public class GreaterExpr extends ExprNode {
	public GreaterExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
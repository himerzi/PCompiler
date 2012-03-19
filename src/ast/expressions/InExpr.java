
package ast.expressions; 

import visitor.Visitor;

public class InExpr extends ExprNode {
	public InExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
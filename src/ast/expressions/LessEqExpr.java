
package ast.expressions; 

import visitor.Visitor;

public class LessEqExpr extends ExprNode {
	public LessEqExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}

package ast.expressions; 

import visitor.Visitor;

public class LessExpr extends ExprNode {
	public LessExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
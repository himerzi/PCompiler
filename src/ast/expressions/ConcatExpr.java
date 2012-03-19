
package ast.expressions; 

import visitor.Visitor;

public class ConcatExpr extends ExprNode {
	public ConcatExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
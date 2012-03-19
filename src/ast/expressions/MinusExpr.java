
package ast.expressions; 

import visitor.Visitor;

public class MinusExpr extends ExprNode {
	public MinusExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}

package ast.expressions; 

import visitor.Visitor;

public class NotExpr extends ExprNode {
	public NotExpr(ExprNode l) { left = l; }
	public Object accept(Visitor v) { return v.visit(this); }
}
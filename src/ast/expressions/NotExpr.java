
package ast.expressions; 

import ast.Visitor;

public class NotExpr extends ExprNode {
	public NotExpr(ExprNode l) { left = l; }
	public Object accept(Visitor v) { return v.visit(this); }
}
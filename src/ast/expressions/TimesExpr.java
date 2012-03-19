
package ast.expressions; 

import visitor.Visitor;

public class TimesExpr extends ExprNode {
	public TimesExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
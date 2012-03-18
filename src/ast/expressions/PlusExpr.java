
package ast.expressions; 

import ast.Visitor;

public class PlusExpr extends ExprNode {
	public PlusExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
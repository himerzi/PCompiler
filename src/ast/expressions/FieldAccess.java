
package ast.expressions; 

import ast.Visitor;

public class FieldAccess extends ExprNode {
	public FieldAccess(ExprNode l, FieldAccess r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
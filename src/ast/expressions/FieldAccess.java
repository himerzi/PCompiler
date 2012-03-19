
package ast.expressions; 

import visitor.Visitor;

public class FieldAccess extends ExprNode {
	public FieldAccess(Id l, FieldAccess r) { left = l ; right = r; }
	//for whenever we have id.id, i.e. we only have one level of nesting
	public FieldAccess(Id l,  Id r) { left = l ; right = r; }
	public Object accept(Visitor v) { return v.visit(this); }
}
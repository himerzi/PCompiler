
package ast.expressions; 

import ast.Visitor;

public class Id extends ExprNode {
	public String id;
	public Id(String id) { this.id = id; }
	public Object accept(Visitor v) { return v.visit(this); }
}
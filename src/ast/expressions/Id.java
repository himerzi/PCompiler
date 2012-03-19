
package ast.expressions; 

import visitor.Visitor;

public class Id extends ExprNode {
	public String id;
	public Id(String id) { this.id = id; }
	public Id(Id id){
	       this.id = id.id;
	   }
	public Object accept(Visitor v) { return v.visit(this); }
}
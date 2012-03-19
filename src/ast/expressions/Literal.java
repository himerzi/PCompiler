package ast.expressions;

import visitor.Visitor;
import ast.PrimitiveType;

public class Literal extends ExprNode {
	Object value;
	PrimitiveType type;
	public Literal(Object value, PrimitiveType type){
		this.value = value; this.type = type;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}
//function call for sum(3,8) + 8
//function statmeent for stmt like assignment
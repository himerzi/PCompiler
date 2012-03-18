package ast.expressions;

import ast.PrimitiveTypes;
import ast.Visitor;

public class Literal extends ExprNode {
	Object value;
	PrimitiveTypes type;
	public Literal(Object value, PrimitiveTypes type){
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
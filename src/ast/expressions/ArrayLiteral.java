package ast.expressions;

import visitor.Visitor;

public class ArrayLiteral extends ExprNode {
	// id[element]
	public ArrayLiteral(Id id, ExprNode element){
		left = id; right = element;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

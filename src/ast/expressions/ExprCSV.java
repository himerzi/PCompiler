package ast.expressions;

import visitor.Visitor;

public class ExprCSV extends ExprNode {
	public ExprCSV(ExprNode l, ExprNode r){
		left = l; right  = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

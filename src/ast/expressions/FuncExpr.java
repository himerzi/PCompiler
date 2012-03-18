package ast.expressions;

import ast.Visitor;

public class FuncExpr extends ExprNode {
	//store csv
	public FuncExpr(Id id, ExprCSV args){
		left = id; right = args;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

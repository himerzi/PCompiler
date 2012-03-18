package ast.statements;

import ast.Visitor;
import ast.expressions.ExprCSV;
import ast.expressions.ExprNode;
import ast.expressions.Id;

public class FuncStmt extends ExprNode {
	public FuncStmt(Id id, ExprCSV args){
		left = id; right = args;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

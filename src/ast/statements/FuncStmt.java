package ast.statements;

import visitor.Visitor;
import ast.expressions.ExprCSV;
import ast.expressions.Id;

public class FuncStmt extends StmtNode {
	public FuncStmt(Id id, ExprCSV args){
		left = id; right = args;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

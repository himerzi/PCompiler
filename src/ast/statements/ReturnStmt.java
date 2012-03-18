package ast.statements;

import ast.Visitor;
import ast.expressions.ExprNode;

public class ReturnStmt extends StmtNode {
	public ReturnStmt(ExprNode l){
		left = l;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

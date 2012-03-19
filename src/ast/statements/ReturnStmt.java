package ast.statements;

import visitor.Visitor;
import ast.expressions.ExprNode;

public class ReturnStmt extends StmtNode {
	public ReturnStmt(ExprNode l){
		left = l;
	}
	public ReturnStmt(){}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

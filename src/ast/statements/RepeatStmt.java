package ast.statements;

import ast.Body;
import ast.Visitor;
import ast.expressions.ExprNode;

public class RepeatStmt extends StmtNode {
	public RepeatStmt(Body l, ExprNode r){
		left = l; right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

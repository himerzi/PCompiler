package ast.statements;

import visitor.Visitor;
import ast.Block;
import ast.expressions.ExprNode;

public class RepeatStmt extends StmtNode {
	public RepeatStmt(Block l, ExprNode r){
		left = l; right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

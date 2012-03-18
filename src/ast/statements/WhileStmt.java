package ast.statements;

import ast.Block;
import ast.Visitor;
import ast.expressions.ExprNode;

public class WhileStmt extends StmtNode{
	public WhileStmt(ExprNode l, Block r){
		left = l;right =r;
	}
	public Object accept(Visitor v){
		return v.visit(this);
	}
}

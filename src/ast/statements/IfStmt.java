package ast.statements;

import visitor.Visitor;
import ast.Block;
import ast.expressions.ExprNode;

public class IfStmt extends StmtNode{
	Block els = null;
	public IfStmt(ExprNode l, Block r, Block els){
		left = l;right =r;
		this.els = els;
	}
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
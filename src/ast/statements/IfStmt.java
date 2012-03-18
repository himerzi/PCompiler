package ast.statements;

import ast.Body;
import ast.Visitor;
import ast.expressions.ExprNode;

public class IfStmt extends StmtNode{
	Body els = null;
	public IfStmt(ExprNode l, Body r, Body els){
		left = l;right =r;
		this.els = els;
	}
	public Object accept(Visitor v){
		return v.visit(this);
	}
}
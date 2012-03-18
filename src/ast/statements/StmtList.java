package ast.statements;

import ast.Visitor;

public class StmtList extends StmtNode{
	public StmtList(StmtNode l, StmtNode r){
		left = l;right =r;
	}
	public Object accept(Visitor v){
		return v.visit(this);
	}
}

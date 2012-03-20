package ast.statements;

import visitor.Visitor;

public class StmtList extends StmtNode{
	public StmtList(StmtNode l, StmtList r){
		left = l;right =r;
	}
	public Object accept(Visitor v){
		return v.visit(this);
	}
}

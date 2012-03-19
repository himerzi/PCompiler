package ast;

import visitor.Visitor;
import ast.declarations.DeclList;
import ast.statements.StmtList;

public class Body extends Node {
	public Body(DeclList l, StmtList r){
		left = l;
		right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

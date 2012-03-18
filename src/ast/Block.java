package ast;

import ast.statements.ReturnStmt;

public class Block extends Node {
	public Block(Body l, ReturnStmt r){
		left = l; right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

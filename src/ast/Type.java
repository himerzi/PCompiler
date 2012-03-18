package ast;

import ast.expressions.Id;


public class Type extends Node {
	String type;
	public Type(String type){
		this.type = type;
	}
	public Type(Id id){
		type = id.id;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

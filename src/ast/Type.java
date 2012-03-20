package ast;

import visitor.Visitor;
import ast.expressions.Id;


public class Type extends Node {
	public String type;
	public Type(String type){
		this.type = type;
	}
	public Type(Id id){
		type = id.id;
	}
	public String toString(){
		return type;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

package ast;

import visitor.Visitor;
import ast.declarations.DeclList;

public class Root extends Node {
	public Root(DeclList l, Body r){
		left = l; right = r;
	}
	
	@Override
	public Object accept(Visitor v){
		return null;
	};

}

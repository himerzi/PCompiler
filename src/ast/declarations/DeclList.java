package ast.declarations;

import ast.Visitor;

public class DeclList extends DeclNode {
	public DeclList(DeclNode l, DeclNode r){
		left = l; right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

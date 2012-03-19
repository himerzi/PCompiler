package ast.declarations;

import visitor.Visitor;

public class DeclList extends DeclNode {
	public DeclList(DeclNode l, DeclList r){
		left = l; right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

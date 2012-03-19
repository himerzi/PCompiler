package ast.declarations;

import visitor.Visitor;

public class ArgList extends DeclNode {
	public ArgList(VarDeclSimple l, ArgList r){
		left = l; right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

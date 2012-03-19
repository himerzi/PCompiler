package ast.sequences;

import ast.expressions.ExprCSV;
import visitor.Visitor;

public class List extends SequenceNode {
	public List(ExprCSV l){
		left = l;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

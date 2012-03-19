package ast.sequences;

import visitor.Visitor;

public class Str extends SequenceNode {
	public String val;
	public Str(String l){
		val = l;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

package ast.statements;

import visitor.Visitor;
import ast.expressions.ArrayLiteral;
import ast.expressions.ExprNode;
import ast.expressions.Id;

public class Assign extends StmtNode {
	//only these things can receive an assignment
	public Assign(Id i, ExprNode e){
		left = i; right = e;
	}
	public Assign(ArrayLiteral i, ExprNode e){
		left = i; right = e;
	}
	public Assign(ExprNode i, ExprNode e){
		left = i; right = e;
	}
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}

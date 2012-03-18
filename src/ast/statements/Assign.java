package ast.statements;

import ast.Visitor;
import ast.expressions.ArrayLiteral;
import ast.expressions.ExprNode;
import ast.expressions.FieldAccess;
import ast.expressions.Id;

public class Assign extends StmtNode {
	//only these things can receive an assignment
	public Assign(Id i, ExprNode e){
		left = i; right = e;
	}
	public Assign(ArrayLiteral i, ExprNode e){
		left = i; right = e;
	}
	public Assign(FieldAccess i, ExprNode e){
		left = i; right = e;
	}
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}

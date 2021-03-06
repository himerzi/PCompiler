package ast.declarations;

import visitor.Visitor;
import ast.expressions.ExprNode;
/*
 * variable_decl ::= ID COLON declared_type SEMI
*	| ID COLON declared_type EQ expr SEMI
*	| ID error error_recovery_token {: parser.printErrorDescription(CUP$parser$actions.COLON_MISSING); :}
*	| ID COLON declared_type error error_recovery_token {: parser.printErrorDescription(CUP$parser$actions.SEMI_MISSING); :}
*	;
 */
public class VarDeclComplex extends DeclNode {
	public VarDeclComplex(VarDeclSimple l, ExprNode r){
		right =r; left = l;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

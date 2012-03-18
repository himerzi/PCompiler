package ast.declarations;

import ast.Body;
import ast.Visitor;
import ast.expressions.Id;

/*
* * function_decl ::= FDEF ID LPAREN comma_separated_params RPAREN COLON TYPE code_block_return
*	| FDEF ID LPAREN comma_separated_params RPAREN COLON VOID code_block_no_return
*	| FDEF error error_recovery_token {: parser.printErrorDescription(CUP$parser$actions.FDEF_NAME_NOT_FOUND); :}
*	| FDEF ID error error_recovery_token {: parser.printErrorDescription(CUP$parser$actions.LPAREN_MISMATCH); :}
*	| FDEF ID LPAREN comma_separated_params error error_recovery_token {: parser.printErrorDescription(CUP$parser$actions.RPAREN_MISMATCH); :}
*	| FDEF ID LPAREN comma_separated_params RPAREN error error_recovery_token {: parser.printErrorDescription(CUP$parser$actions.COLON_MISSING); :}
*	;  
 */
public class FuncDecl extends DeclNode {
	Id id;
	public FuncDecl(Id id, ArgList l, Body r){
		this.id = id; left = l; right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

}

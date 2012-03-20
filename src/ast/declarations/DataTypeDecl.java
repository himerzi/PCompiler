package ast.declarations;

import visitor.Visitor;
import ast.expressions.Id;

public class DataTypeDecl extends DeclNode {
/*	data_type_decl ::= TDEF ID COLON comma_separated_params SEMI
 *	| TDEF error error_recovery_token {: parser.printErrorDescription(CUP$parser$actions.FDEF_NAME_NOT_FOUND); :}
 *	;
 */	
	public DataTypeDecl(Id l,ArgList r){
		left = l; right = r;
	}
	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);	
	}

}

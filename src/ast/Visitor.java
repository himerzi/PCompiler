package ast;

import ast.declarations.*;
import ast.expressions.*;
import ast.statements.*;

public interface Visitor {
	Object visit(Body e);
	Object visit(Type e);
	Object visit(Block e);
	Object visit(Root e);
	
	Object visit(PlusExpr e);
	Object visit(ExprNode e);
	Object visit(TimesExpr e);
	Object visit(MinusExpr e);
	Object visit(DivExpr e);
	Object visit(PowerExpr e);
	Object visit(EqqExpr e);
	Object visit(NotEqqExpr e);
	Object visit(AndExpr e);
	Object visit(OrExpr e);
	Object visit(LessExpr e);
	Object visit(LessEqExpr e);
	Object visit(GreaterExpr e);
	Object visit(Id e);
	Object visit(FieldAccess e);
	Object visit(GreaterEqExpr e);
	Object visit(InExpr e);
	Object visit(NotInExpr e);
	Object visit(ConcatExpr e);
	Object visit(NotExpr e);

	Object visit(StmtNode e);
	Object visit(IfStmt e);
	Object visit(Assign e);
	Object visit(WhileStmt e);
	Object visit(StmtList e);
	Object visit(RepeatStmt e);
	Object visit(ReturnStmt e);
	
	Object visit(ArgList e);
	Object visit(DeclList e);
	Object visit(VarDeclSimple e);
	Object visit(VarDeclComplex e);	
	Object visit(FuncDecl e);
	Object visit(DataTypeDecl e);

}

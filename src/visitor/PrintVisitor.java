package visitor;

import ast.Block;
import ast.Body;
import ast.Root;
import ast.Type;
import ast.declarations.ArgList;
import ast.declarations.DataTypeDecl;
import ast.declarations.DeclList;
import ast.declarations.FuncDecl;
import ast.declarations.VarDeclComplex;
import ast.declarations.VarDeclSimple;
import ast.expressions.AndExpr;
import ast.expressions.ArrayLiteral;
import ast.expressions.ConcatExpr;
import ast.expressions.DivExpr;
import ast.expressions.EqqExpr;
import ast.expressions.ExprCSV;
import ast.expressions.FieldAccess;
import ast.expressions.FuncExpr;
import ast.expressions.GreaterEqExpr;
import ast.expressions.GreaterExpr;
import ast.expressions.Id;
import ast.expressions.InExpr;
import ast.expressions.LessEqExpr;
import ast.expressions.LessExpr;
import ast.expressions.Literal;
import ast.expressions.MinusExpr;
import ast.expressions.NotEqqExpr;
import ast.expressions.NotExpr;
import ast.expressions.NotInExpr;
import ast.expressions.OrExpr;
import ast.expressions.PlusExpr;
import ast.expressions.PowerExpr;
import ast.expressions.TimesExpr;
import ast.sequences.List;
import ast.sequences.Tuple;
import ast.statements.Assign;
import ast.statements.FuncStmt;
import ast.statements.IfStmt;
import ast.statements.RepeatStmt;
import ast.statements.ReturnStmt;
import ast.statements.StmtList;
import ast.statements.WhileStmt;

public class PrintVisitor implements Visitor {

	@Override
	public Object visit(Body e) {
		try{
			e.right.accept(this);
		}catch(NullPointerException e){
		}
		try{
			e.left.accept(this);
		}catch(NullPointerException e){
		}
		return null;
	}

	@Override
	public Object visit(Type e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Block e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Root e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PlusExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(TimesExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MinusExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DivExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PowerExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(EqqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotEqqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AndExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OrExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessEqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Id e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FieldAccess e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterEqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(InExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotInExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ConcatExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArrayLiteral e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExprCSV e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Literal e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Assign e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WhileStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(StmtList e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RepeatStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ReturnStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArgList e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DeclList e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VarDeclSimple e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VarDeclComplex e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncDecl e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DataTypeDecl e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(List e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Tuple e) {
		// TODO Auto-generated method stub
		return null;
	}

}

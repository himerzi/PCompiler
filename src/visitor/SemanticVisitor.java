package visitor;

import ast.Block;
import ast.Body;
import ast.PrimitiveType;
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

public class SemanticVisitor implements Visitor {
	private SymbolTable table;
	/*
public Type visit(PlusExp n) { Type t1 = n.left.accept(this); Type t2 = n.right.accept(this); if (t1 == IntType && t2==IntType) return IntType; else throw new TypeCheckError();
}
public Type visit(Identifier n) { Type t = symTable.lookupType(n.name); if (t!=null && t==IntType) return IntType; else throw new TypeCheckError();
}
	 */
	public SemanticVisitor(SymbolTable t){
		table = t;
	}
	@Override
	public PrimitiveType visit(Body e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(Type e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(Block e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(Root e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(PlusExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(TimesExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(MinusExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(DivExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(PowerExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(EqqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(NotEqqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(AndExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(OrExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(LessExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(LessEqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(GreaterExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public PrimitiveType visit(Id e) {
//		Type t = symTable.lookupType(n.name); 
//		if (t!=null && t==IntType) 
//			return IntType; 
//		else 
//			throw new TypeCheckError();
//		return null;
//	}

	@Override
	public PrimitiveType visit(FieldAccess e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(GreaterEqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(InExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(NotInExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(ConcatExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(NotExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(FuncExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(ArrayLiteral e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(ExprCSV e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(Literal e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(IfStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(Assign e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(WhileStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(StmtList e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(RepeatStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(ReturnStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(FuncStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(ArgList e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(DeclList e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(VarDeclSimple e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(VarDeclComplex e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(FuncDecl e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(DataTypeDecl e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(List e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrimitiveType visit(Tuple e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visit(Id e) {
		// TODO Auto-generated method stub
		return null;
	}

}

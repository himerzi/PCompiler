package visitor;

import java.util.ArrayList;

import visitor.SymbolTable.EntryKind;
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
import ast.expressions.ConcatExpr;
import ast.expressions.DivExpr;
import ast.expressions.EqqExpr;
import ast.expressions.ExprNode;
import ast.expressions.FieldAccess;
import ast.expressions.GreaterEqExpr;
import ast.expressions.GreaterExpr;
import ast.expressions.Id;
import ast.expressions.InExpr;
import ast.expressions.LessEqExpr;
import ast.expressions.LessExpr;
import ast.expressions.MinusExpr;
import ast.expressions.NotEqqExpr;
import ast.expressions.NotExpr;
import ast.expressions.NotInExpr;
import ast.expressions.OrExpr;
import ast.expressions.PlusExpr;
import ast.expressions.PowerExpr;
import ast.expressions.TimesExpr;
import ast.statements.Assign;
import ast.statements.IfStmt;
import ast.statements.RepeatStmt;
import ast.statements.ReturnStmt;
import ast.statements.StmtList;
import ast.statements.StmtNode;
import ast.statements.WhileStmt;

public class ScopeVisitor implements Visitor {
	SymbolTable table;
	ArrayList<Type> tempList;
	public ScopeVisitor(){
		table = new SymbolTable();
	}
	@Override
	public Boolean visit(Body e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Type e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Block e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Root e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(PlusExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(ExprNode e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(TimesExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(MinusExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(DivExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(PowerExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(EqqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NotEqqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(AndExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(OrExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(LessExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(LessEqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(GreaterExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Id e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(FieldAccess e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(GreaterEqExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(InExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NotInExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(ConcatExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NotExpr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(StmtNode e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(IfStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Assign e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(WhileStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(StmtList e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(RepeatStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(ReturnStmt e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Type> visit(ArgList e) {
		ArrayList<Type> list = new ArrayList<Type>();
		VarDeclSimple typeInfo = (VarDeclSimple)e.left;
		list.add(typeInfo.type);
		//how do i colllect ze list !?
		if(e.left == null){
			
		}else{
			list.addAll((ArrayList<Type>)e.right.accept(this));
		}
		return list;
	}

	@Override
	public Boolean visit(DeclList e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(VarDeclSimple e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(VarDeclComplex e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(FuncDecl e) {
		ArrayList<Type> types = new ArrayList<Type>();
		tempList = new ArrayList<Type>();
		tempList.add(e.type);
		//where parameter list is declared
		tempList.addAll((ArrayList<Type>)e.left.accept(this));
		table.put(e.id.id, e.id.id, EntryKind.METHOD,tempList);
		//begin new scope
		return null;
	}

	@Override
	public Boolean visit(DataTypeDecl e) {
		// TODO Auto-generated method stub
		return null;
	}

}

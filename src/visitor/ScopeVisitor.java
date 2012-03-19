package visitor;

import java.util.ArrayList;
import java.util.WeakHashMap;

import java_cup.runtime.lr_parser;

import visitor.SymbolTable.EntryKind;
import ast.Block;
import ast.Body;
import ast.Root;
import ast.Type;
import ast.declarations.ArgList;
import ast.declarations.DataTypeDecl;
import ast.declarations.DeclList;
import ast.declarations.DeclNode;
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
import ast.sequences.List;
import ast.sequences.Str;
import ast.sequences.Tuple;
import ast.statements.Assign;
import ast.statements.IfStmt;
import ast.statements.RepeatStmt;
import ast.statements.ReturnStmt;
import ast.statements.StmtList;
import ast.statements.StmtNode;
import ast.statements.WhileStmt;

public class ScopeVisitor implements Visitor {
	SymbolTable table;
	public ScopeVisitor(){
		table = new SymbolTable();
	}
	@Override
	public Boolean visit(Body e) {
		try {
			// a decllist
			e.left.accept(this);
			//a statment list
			e.right.accept(this);
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("an empty body");
		}
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
		//a body
		e.left.accept(this);
		// a return statement
		e.right.accept(this);
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return returns the entire symbol table for the program
	 */
	@Override
	public SymbolTable visit(Root e) {
		//(DeclList l, Body r){
		try {
			e.left.accept(this);
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			System.out.println("root has empty decllist");
		}
		e.right.accept(this);
		// TODO Auto-generated method stub
		return table;
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
	public ArrayList<VarDeclSimple> visit(ArgList e) {
		// we will collect everything into here
		ArrayList<VarDeclSimple> list = new ArrayList<VarDeclSimple>();
		//where the type information for every arg is stored
		VarDeclSimple typeInfo = (VarDeclSimple)e.left;
		list.add(typeInfo);
		if(e.right != null){
			list.addAll((ArrayList<VarDeclSimple>)e.right.accept(this));
		}
		return list;
	}

	@Override
	public Boolean visit(DeclList e) {
		// DeclNode l, DeclList r
		try{
			e.left.accept(this);
			e.right.accept(this);
		}catch (NullPointerException e1) {
			System.out.println("i've reached a leaf on declList");
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(VarDeclSimple e) {
		//Id id, Type type
		Id id = (Id)e.left;
		ArrayList<VarDeclSimple> temp = new ArrayList<VarDeclSimple>();
		temp.add(e);
		table.put(id.id, id.id, EntryKind.VAR, temp);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(VarDeclComplex e) {
		// (VarDeclSimple l, ExprNode r)
		e.left.accept(this);
		return null;
	}

	@Override
	public Boolean visit(FuncDecl e) {
		//the list of arguments
		ArrayList<VarDeclSimple>tempList = new ArrayList<VarDeclSimple>();
		//the first item of the list will always be the return type
		tempList.add(new VarDeclSimple(null, e.type));
		try {
			//where parameter list is declared
			tempList.addAll((ArrayList<VarDeclSimple>)e.left.accept(this));
			table.put(e.id.id, e.id.id, EntryKind.METHOD,tempList);
			//begin new inner scope for method
			table = table.beginScope();
			//add argument list to scope of method body
			for(int i=1; i< tempList.size();i++){
				ArrayList<VarDeclSimple> temp = new ArrayList<VarDeclSimple>();
				VarDeclSimple entry = (VarDeclSimple)tempList.get(i);
				Id entryId = (Id)entry.left;
				temp.add(entry);
				table.put(entryId.id, entryId.id, EntryKind.VAR, temp);
			}
			// visit the block
			e.right.accept(this);
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			System.out.println("leaf on funcdecl");
		}
		table = table.endScope();
		return true;
	}

	@Override
	public Boolean visit(DataTypeDecl e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visit(List e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visit(Str e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visit(Tuple e) {
		// TODO Auto-generated method stub
		return null;
	}

}

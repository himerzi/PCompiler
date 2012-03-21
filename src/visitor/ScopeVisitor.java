package visitor;

import java.util.ArrayList;
import visitor.SymbolTable.EntryKind;
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

public class ScopeVisitor implements Visitor {
	SymbolTable table;
	public ScopeVisitor(){
		table = new SymbolTable();
	}
	@Override
	public Boolean visit(Body e) {
		try {
			//a decllist
			e.left.accept(this);
		} catch (NullPointerException e1) {
		}
		try {
			//a statment list
			e.right.accept(this);
		} catch (NullPointerException e1) {
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Type e) {
		//check if this is a primitive type. If not, it is a user defined type that needs to be lookup up in sym table.
		String typeS = e.type.toUpperCase();
		boolean primitive = false;
		for(Enum<PrimitiveType> typ:PrimitiveType.values()){
			if(typeS.equals(typ.toString())){
				primitive = true;
				break;
			}
		}
		if (!primitive){
			lookup(e.type);
		}
		return null;
	}

	@Override
	public Boolean visit(Block e) {
		try {
			table = table.beginScope();
			//a body
			e.left.accept(this);
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
		}
		try {
			// a return statement
			e.right.accept(this);
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
		}
		table = table.endScope();
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
		}
		e.right.accept(this);
		// TODO Auto-generated method stub
		return table;
	}

	@Override
	public Boolean visit(PlusExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		// TODO Auto-generated method stub
		if (e.left.nodeType.equals("int") && e.right.nodeType.equals("int")){
			e.nodeType = "int";
		}else if(e.left.nodeType.equals("float") && e.right.nodeType.equals("float")){
			e.nodeType = "float";
		}else{
			System.out.println("Type error: cannot sum " + e.left.nodeType + " and " + e.right.nodeType );
		}
		return null;
	}

	@Override
	public Boolean visit(TimesExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		
		if (e.left.nodeType.equals("int") && e.right.nodeType.equals("int")){
			e.nodeType = "int";
		}else if(e.left.nodeType.equals("float") && e.right.nodeType.equals("float")){
			e.nodeType = "float";
		}else{
			System.out.println("Type error: cannot multiply " + e.left.nodeType + " and " + e.right.nodeType );
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(MinusExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		
		if (e.left.nodeType.equals("int") && e.right.nodeType.equals("int")){
			e.nodeType = "int";
		}else if(e.left.nodeType.equals("float") && e.right.nodeType.equals("float")){
			e.nodeType = "float";
		}else{
			System.out.println("Type error: cannot subtract " + e.left.nodeType + " and " + e.right.nodeType );
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(DivExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		//we can only divide ints or floats
		if ((e.left.nodeType.equals("int") || e.left.nodeType.equals("float"))&&(e.right.nodeType.equals("int")||e.right.nodeType.equals("float"))){
			e.nodeType = "float";
		}else{
			System.out.println("Type error: cannot divide " + e.left.nodeType + " and " + e.right.nodeType );
			//set to prevent a cascade of errors
			e.nodeType = "float";
		}
		return null;
	}

	@Override
	public Boolean visit(PowerExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if (!e.right.nodeType.equals("int")){
			System.out.println("Type error: cannot raise to a non-integer power" );
		}else if(!e.left.nodeType.equals("int")||e.left.nodeType.equals("float")){
			System.out.println("Type error: cannot apply power to a " + e.left.nodeType );
		}else{
			System.out.println("Type error: cannot divide " + e.left.nodeType + " and " + e.right.nodeType );
			//set to prevent a cascade of errors
			e.nodeType = "float";
		}
		return null;
	}

	@Override
	public Boolean visit(EqqExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if (!(e.left.nodeType.equals("bool")||e.left.nodeType.equals("int")||e.left.nodeType.equals("float"))&&(e.left.nodeType.equals(e.right.nodeType))){
			e.nodeType = "bool";
		}else{
			System.out.println("Type error: cannot compare " + e.left.nodeType + " and " + e.right.nodeType );
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NotEqqExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if(!(e.left.nodeType.equals("bool")||e.left.nodeType.equals("int")||e.left.nodeType.equals("float"))&&(e.left.nodeType.equals(e.right.nodeType))){
			System.out.println("Type error: cannot compare " + e.left.nodeType + " and " + e.right.nodeType);
		}
		e.nodeType = "bool";

		return null;
	}

	@Override
	public Boolean visit(AndExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if(!(e.left.nodeType.equals("bool")&&e.right.nodeType.equals("bool"))){
			System.out.println("Type error: cannot compare " + e.left.nodeType + " and " + e.right.nodeType);
		}
		e.nodeType = "bool";
		return null;
	}

	@Override
	public Boolean visit(OrExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if(!(e.left.nodeType.equals("bool")&&e.right.nodeType.equals("bool"))){
			System.out.println("Type error: cannot compare " + e.left.nodeType + " and " + e.right.nodeType);
		}
		e.nodeType = "bool";		
		return null;
	}

	@Override
	public Boolean visit(LessExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if((e.left.nodeType.equals("int")||e.left.nodeType.equals("float"))&&(e.left.nodeType.equals(e.right.nodeType))){
			e.nodeType = "bool";
		}else{
			System.out.println("Type error: cannot compare " + e.left.nodeType + " and " + e.right.nodeType);
		}		return null;
	}

	@Override
	public Boolean visit(LessEqExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if((e.left.nodeType.equals("int")||e.left.nodeType.equals("float"))&&(e.left.nodeType.equals(e.right.nodeType))){
			e.nodeType = "bool";
		}else{
			System.out.println("Type error: cannot compare " + e.left.nodeType + " and " + e.right.nodeType);
		}		return null;
	}

	@Override
	public Boolean visit(GreaterExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if((e.left.nodeType.equals("int")||e.left.nodeType.equals("float"))&&(e.left.nodeType.equals(e.right.nodeType))){
			e.nodeType = "bool";
		}else{
			System.out.println("Type error: cannot compare " + e.left.nodeType + " and " + e.right.nodeType);
		}
		return null;
	}

	@Override
	public Boolean visit(GreaterEqExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if((e.left.nodeType.equals("int")||e.left.nodeType.equals("float"))&&(e.left.nodeType.equals(e.right.nodeType))){
			e.nodeType = "bool";
		}else{
			System.out.println("Type error: cannot compare " + e.left.nodeType + " and " + e.right.nodeType);
		}
		return null;
	}
	@Override
	public Boolean visit(Id e) {
		if(lookup(e.id)){
			e.nodeType = table.getType(e.id);
		}
		return null;
	}

	@Override
	public Boolean visit(FieldAccess e) {
		//FieldAccess(ExprNode l, FieldAccess r)
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		// TODO Auto-generated method stub
		e.nodeType = e.right.nodeType;
		return null;

	}

	@Override
	public Boolean visit(InExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		//list, str, tuple
		if(!e.left.nodeType.equals("str")){
			System.out.println("Type error: in cannot operate on " + e.left.nodeType);
		}
		//prevent cascade
		e.nodeType = "bool";

		return null;
	}

	@Override
	public Boolean visit(NotInExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}		
		if(!e.left.nodeType.equals("str")){
			System.out.println("Type error: in cannot operate on " + e.left.nodeType);
		}
		//prevent cascade
		e.nodeType = "bool";
		return null;
	}

	@Override
	public Boolean visit(ConcatExpr e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}	
		if(!(e.left.nodeType.equals("str")||e.left.nodeType.equals("list")||e.left.nodeType.equals("tuple"))){
			System.out.println("Type error: ::(concatenation) cannot operate on " + e.left.nodeType);
		}else if(!(e.right.nodeType.equals("str")||e.right.nodeType.equals("list")||e.right.nodeType.equals("tuple"))){
			System.out.println("Type error: ::(concatenation) cannot operate on " + e.left.nodeType);
		}
		//prevent cascade
		e.nodeType = "bool";
		return null;
	}

	@Override
	public Boolean visit(NotExpr e) {
		try{
			//unary operator, one child
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}		
		if(!e.left.nodeType.equals("bool")){
			System.out.println("Type error: cannot apply ! (not) operator to " + e.left.nodeType);
		}
		e.nodeType = "bool";
		return null;
	}

	@Override
	public Object visit(FuncExpr e) {
		String funcId = ((Id)e.left).id;
		if(lookup(funcId)){
			e.nodeType = table.getType(funcId);
		}
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean visit(IfStmt e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}		
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}		
		try{
			e.els.accept(this);
		}catch (NullPointerException e1) {
		}		return null;
	}

	@Override
	public Boolean visit(Assign e) {
		try{
			//id
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			//expr
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if(!e.left.nodeType.equals(e.right.nodeType)){
			System.out.println("Type error: Cannot assign a " + e.right.nodeType + " to a " + e.left.nodeType);
		}
		e.nodeType = e.right.nodeType;
		return null;
	}

	@Override
	public Boolean visit(WhileStmt e) {
		// TODO Auto-generated method stub
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		return null;
	}

	@Override
	public Boolean visit(StmtList e) {
		try{
			//stmtnode
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			//stmtnode
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(RepeatStmt e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		return null;
	}

	@Override
	public Boolean visit(ReturnStmt e) {
		try{
			//exprnode
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}

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
			e.right.accept(this);
		}catch (NullPointerException e1) {
			System.out.println("i've reached a leaf on declList");
		}
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
			System.out.println("i've reached a leaf on declList");
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(VarDeclSimple e) {
		try{
			e.right.accept(this);
		}catch(NullPointerException e1){
		}
		//Id id, Type type
		Id id = (Id)e.left;
		ArrayList<VarDeclSimple> temp = new ArrayList<VarDeclSimple>();
		temp.add(e);
		table.put(id.id, id.id, EntryKind.VAR, temp);
		// TODO Auto-generated method stub
		Type t = (Type)e.right;
		//set for typechecking
		e.nodeType = t.type;
		return null;
	}

	@Override
	public Boolean visit(VarDeclComplex e) {
		// (VarDeclSimple l, ExprNode r)
		try{
			//a simple decl
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		if(!e.left.nodeType.equals(e.right.nodeType)){
			System.out.println("Type error: cannot instantiate a " + e.left.nodeType + " to a " + e.right.nodeType);
		}
		return null;
	}

	@Override
	public Boolean visit(FuncDecl e) {
		//the list of arguments
		ArrayList<VarDeclSimple>tempList = new ArrayList<VarDeclSimple>();
		//the first item of the list will always be the return type
		tempList.add(new VarDeclSimple(null, e.type));
		try {
			//where argument list is declared
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
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			System.out.println("leaf on funcdecl");
		}
		try {
			// visit the block
			e.right.accept(this);
		} catch (NullPointerException e1) {
		}
		table = table.endScope();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean visit(DataTypeDecl e) {
		Id id = (Id)e.left;
		ArrayList<VarDeclSimple> argList = new ArrayList<VarDeclSimple>();
		//where argument list is declared
		argList.addAll((ArrayList<VarDeclSimple>)e.right.accept(this));
		table.put(id.id, id.id, EntryKind.TDEF,argList);
		return null;
	}
	@Override
	public Object visit(List e) {
		try {
			e.left.accept(this);
		} catch (NullPointerException e1) {
		}
		e.nodeType="list";
		return null;
	}
	@Override
	public Object visit(Tuple e) {
		try {
			e.left.accept(this);
		} catch (NullPointerException e1) {
		}
		e.nodeType="list";

		return null;
	}
	@Override
	public Object visit(FuncStmt e) {
		String funcId = ((Id)e.left).id;
		lookup(funcId);
		// TODO Auto-generated method stub
		return true;
	}
	private boolean lookup(String key){

		if(!table.lookup(key)){
			System.out.println("Scope error: "+key + " has not been declared, or is not in scope.");
			return false;
		}
		return true;
	}
	@Override
	public Object visit(ArrayLiteral e) {
		// ArrayLiteral(Id id, ExprNode element)
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}
		//this is the actual name of the array
		String key = ((Id)e.left).id;
		if(lookup(key)){
			e.nodeType = table.getType(key);
		}
		return null;
	}
	@Override
	public Object visit(ExprCSV e) {
		try{
			e.left.accept(this);
		}catch (NullPointerException e1) {
		}
		try{
			e.right.accept(this);
		}catch (NullPointerException e1) {
		}		
		return null;
	}
	@Override
	public Object visit(Literal e) {
		e.nodeType = e.type.toString().toLowerCase();
		return null;
	}


}

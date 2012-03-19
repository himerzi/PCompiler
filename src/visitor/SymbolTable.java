package visitor;

import java.util.ArrayList;
import java.util.Hashtable;

import ast.Type;

public class SymbolTable {
	SymbolTable parent;
	ArrayList<SymbolTable> children;
	//SymbolTable rootTable = new SymbolTable();
    // necessary ?SymbolTable parentTable = new SymbolTable();
    java.util.Hashtable<String, Row> table;
    
	public SymbolTable(){
		table = new Hashtable<String, Row>();
		}
	public void put(String key, String i, EntryKind k, ArrayList<Type> t){
		table.put(key, new Row(i, k, t));
	}
	public Row get(String key) {
		return table.get(key);
	}
	public SymbolTable beginScope() {
		SymbolTable newTable = new SymbolTable();
		newTable.setParent(this);
		children.add(newTable); 
		return newTable;
	}
	public SymbolTable endScope() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(SymbolTable parent) {
		this.parent = parent;
	}
	public class Row{
		EntryKind kind;
		String id;		
		private ArrayList<Type> type;
		//in the case of a variable
		private Type typesing = null;
		/**
		 * @param t the type, or if method, a list of the parameter types in order, followed by any non-letter, followed by return type
		 */		
		public Row(String i,EntryKind k, ArrayList<Type> t){
			kind = k; id = i; type = t;
		}
		public Row(String i,EntryKind k, Type t){
			kind = k; id = i; typesing = t;
		}

	}
	public enum EntryKind{
		METHOD,VAR
	}
}
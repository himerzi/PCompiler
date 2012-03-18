package ast;

import java.util.ArrayList;

public class SymbolTable {
	SymbolTable parent;
	ArrayList<SymbolTable> children;
	SymbolTable rootTable = new SymbolTable();
    SymbolTable parentTable = new SymbolTable();
    java.util.Hashtable<String, Object> table;
    
	public SymbolTable(){
		// initialise table
		}
/*	public SymbolTable put(String key, Object value){
		// insert a new binding into a table
	}
	public Object get(String key) {
		// look a binding up 
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
}
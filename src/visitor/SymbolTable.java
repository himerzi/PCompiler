package visitor;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import ast.Type;
import ast.declarations.VarDeclSimple;
import ast.expressions.Id;

public class SymbolTable {
	SymbolTable parent;
	ArrayList<SymbolTable> children;
	//SymbolTable rootTable = new SymbolTable();
    // necessary ?SymbolTable parentTable = new SymbolTable();
    java.util.Hashtable<String, Row> table;
    
	public SymbolTable(){
		table = new Hashtable<String, Row>();
		children = new ArrayList<SymbolTable>();
		}
	public void put(String key, String i, EntryKind k, ArrayList<VarDeclSimple> t){
		if(table.containsKey(key)){
			System.out.println("Scope Error: "+key+" has allready been decalred.");
		}else{
			table.put(key, new Row(i, k, t));
		}
	}
	public Row get(String key) {
		return table.get(key);
	}
	public Boolean lookup(String key){
		return search(key) == null?false:true;
	}
	public Row search(String key){
		SymbolTable t = this;
		Row ans = t.table.get(key);
		while(t != null && ans == null){
			t = t.endScope();
			if(t!=null){
				ans = t.table.get(key);
			}
		}
		return ans;
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
	public String toString(){
		String r = "--------Begin Symbol Table------\n";
		for (Map.Entry<String, Row> entry : table.entrySet()) {
			r += entry.getValue().toString() + '\n';
		}
		r += "--------End Symbol Table------\n";
		for (SymbolTable t:children) {
			r += "--------Begin Symbol Table------\n";
			for (Map.Entry<String, Row> entry : t.table.entrySet()) {
				r += entry.getValue().toString() + '\n';
			}
			r += "--------End Symbol Table------\n";
		}
		return r;
	}
	public class Row{
		EntryKind kind;
		String id;		
		private ArrayList<VarDeclSimple> type;
		//in the case of a variable
		/**
		 * @param t the type, or if method, a list of the parameter types in order, followed by any non-letter, followed by return type
		 */		
		public Row(String i,EntryKind k, ArrayList<VarDeclSimple> t){
			kind = k; id = i; type = t;
		}
		public String toString(){
			String typeinfo = "";
			String t = "->";
			for(VarDeclSimple v:type){
				if(v.left != null){
					t = ((Id)v.left).id;
				}
				typeinfo = t + ":" + ((Type)v.right).type +"," + typeinfo ;
			}
			return  kind.toString() + " " + id + " " + typeinfo  ;
		}

	}
	public enum EntryKind{
		METHOD,VAR,TDEF
	}
}
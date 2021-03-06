package compiler;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import visitor.SemanticVisitor;
import visitor.SymbolTable;

import ast.Root;

import java_cup.runtime.Symbol;

public class PCompiler {

  private static final String input = getInputStream();

  public static void main(String args[]){
  	Yylex myScanner = new Yylex(new ByteArrayInputStream( input.getBytes() ));
	parser myParser = new parser(myScanner);
	try{
		Symbol result= myParser.parse();
		Root root = (Root)result.value;
		SemanticVisitor sv = new SemanticVisitor();
		root.accept(sv);
		System.out.println("--------------------------------------------------------------------------");
	} catch(Exception e){
		e.printStackTrace();
		System.out.println("\n - Error in processing P File.");
		myParser.parseSuccessReport(false);
	}
    }

	private static String getInputStream(){
		//we need a way of printing lines with errors in them, so
		//we make a copy of the input stream, to use for the error/debugging output
	   return convertStreamToString(System.in);
	}
	private static String convertStreamToString(java.io.InputStream is) {
	    try {
	        return new java.util.Scanner(is).useDelimiter("\\A").next();
	    } catch (java.util.NoSuchElementException e) {
	        return "";
	    }
	}
	
	// Takes 0-indexed line numbers
	public static String getLine(int line){
		Scanner sc = new Scanner(input);
		int i = 0;
		while (sc.hasNextLine()) {
			String scan = sc.nextLine();
			if(i == line)
				return scan;
			i++; 
		}
		return "";
	}
	
	public static int getColumn(int yychar){
		int start = yychar;
		while(input.charAt(start) != '\n' && start != 0){
			start--;
		}
		return yychar-start-1;
	}

}
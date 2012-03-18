package compiler;

class Test{
	
	public static void main(String args[]) throws Exception {
		/* init the automatically generated scanner from calc.lex */
		Yylex myScanner = new Yylex(System.in);
	//System.err.
		/* init the automatically generated parser from calc.cup */
		parser myParser = new parser(myScanner);
		/* parse the input program from stdin */
		myParser.parse();		
	}
}

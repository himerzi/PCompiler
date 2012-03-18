package compiler;

import java.io.*;

import java_cup.runtime.Symbol;

public class TestScanner {

    public static void main (String[] args) throws IOException {
	
	Yylex myscanner = new Yylex(System.in);
	//myscanner.
	Symbol nextToken = myscanner.next_token();

	while (nextToken != null) {
	    System.out.println(nextToken.value);
	    System.out.println(nextToken.sym);
	    System.out.println("-------");


	    nextToken = myscanner.next_token();
	}


    }

}
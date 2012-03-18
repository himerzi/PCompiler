package compiler;
import java_cup.runtime.Symbol;
import PSymbol.*;
import ast.expressions.*;

class LexicalError{
	private static int lexicalErrorCount = 0;
	
	public static int getLexicalErrorCount(){
		return lexicalErrorCount;
	}
	public static void increaseError(){
		lexicalErrorCount++;
	}
	public static String createLexicalErrorDescription(String yytext, int yyline, int yychar, String cause){
		int columnNumber = PCompiler.getColumn(yychar) - 1;
		String lineString = PCompiler.getLine(yyline);
		
		String descriptionText = "\n " + "- Lexical error near token \'" + yytext + "\'" + " on line " +
								 (yyline + 1) + ", column " + columnNumber + " found:\n\n";
		String descriptionLocation = "     ";
		descriptionLocation += "Line " + (yyline + 1) + ": ";
		int tempLength = descriptionLocation.length();
		descriptionLocation += lineString + "\n";
		// Prints caret
		for(int i = 0; i < columnNumber + tempLength; i++){
			descriptionLocation += " ";
		}
		descriptionLocation += "^\n";
		//
		String descriptionCause = "     Possible cause: " + cause;
		return descriptionText + descriptionLocation + descriptionCause;
	}
}
%%

%line 
%char
%cup
%notunix
%state COMMENT

type = bool|int|float|char|str|list|tuple
letter = [a-zA-Z]
digit = [0-9]
number = 0|[1-9]{digit}*
id = {letter}({letter}|{digit})*

int = {number}
float = {int}\.{digit}+
character = (\ |{letter}|{digit})
char = \'{character}\'
bool = true|false

str = \"({character}*)\"

whitespace = [\ \t\r\n\f]

%%

<YYINITIAL>"!" {return new PSymbol(sym.NOT, yytext(), yyline, yychar);}
<YYINITIAL>"||" {return new PSymbol(sym.OR, yytext(), yyline, yychar);}
<YYINITIAL>"&&" {return new PSymbol(sym.AND, yytext(), yyline, yychar);}

<YYINITIAL>"+" {return new PSymbol(sym.PLUS, yytext(), yyline, yychar);}
<YYINITIAL>"*" {return new PSymbol(sym.TIMES, yytext(), yyline, yychar);}
<YYINITIAL>"-" {return new PSymbol(sym.MINUS, yytext(), yyline, yychar);}
<YYINITIAL>"/" {return new PSymbol(sym.DIVIDE, yytext(), yyline, yychar);}
<YYINITIAL>"^" {return new PSymbol(sym.POWER, yytext(), yyline, yychar);}

<YYINITIAL>"<" {return new PSymbol(sym.LESS, yytext(), yyline, yychar);}
<YYINITIAL>"<=" {return new PSymbol(sym.LESSEQ, yytext(), yyline, yychar);}
<YYINITIAL>">" {return new PSymbol(sym.GREATER, yytext(), yyline, yychar);}
<YYINITIAL>">=" {return new PSymbol(sym.GREATEREQ, yytext(), yyline, yychar);}
<YYINITIAL>"==" {return new PSymbol(sym.EQQ, yytext(), yyline, yychar);}
<YYINITIAL>"!=" {return new PSymbol(sym.NOTEQQ, yytext(), yyline, yychar);}

<YYINITIAL>"::" {return new PSymbol(sym.CONCAT, yytext(), yyline, yychar);}

<YYINITIAL>"{" {return new PSymbol(sym.LCURL, yytext(), yyline, yychar);}
<YYINITIAL>"}" {return new PSymbol(sym.RCURL, yytext(), yyline, yychar);}
<YYINITIAL>"(" {return new PSymbol(sym.LPAREN, yytext(), yyline, yychar);}
<YYINITIAL>")" {return new PSymbol(sym.RPAREN, yytext(), yyline, yychar);}
<YYINITIAL>"[" {return new PSymbol(sym.LBRAC, yytext(), yyline, yychar);}
<YYINITIAL>"]" {return new PSymbol(sym.RBRAC, yytext(), yyline, yychar);}
<YYINITIAL>"=" {return new PSymbol(sym.EQ, yytext(), yyline, yychar);}
<YYINITIAL>":" {return new PSymbol(sym.COLON, yytext(), yyline, yychar);}
<YYINITIAL>";" {return new PSymbol(sym.SEMI, yytext(), yyline, yychar);}
<YYINITIAL>"," {return new PSymbol(sym.COMMA, yytext(), yyline, yychar);}
<YYINITIAL>"." {return new PSymbol(sym.DOT, yytext(), yyline, yychar);}

<YYINITIAL>{type} {return new PSymbol(sym.TYPE, yytext(), yyline, yychar);}

<YYINITIAL>void {return new PSymbol(sym.VOID, yytext(), yyline, yychar);}
<YYINITIAL>{bool} {return new PSymbol(sym.BOOL, yytext(), yyline, yychar);}
<YYINITIAL>{int} {return new PSymbol(sym.INT, new Integer(yytext()), yyline, yychar);}
<YYINITIAL>{float} {return new PSymbol(sym.FLOAT, new Float(yytext()), yyline, yychar);}
<YYINITIAL>{char} {return new PSymbol(sym.CHAR, new Character(yytext().charAt(1)), yyline, yychar);}

<YYINITIAL>"[|" {return new PSymbol(sym.LTUPLE, yytext(), yyline, yychar);}
<YYINITIAL>"|]" {return new PSymbol(sym.RTUPLE, yytext(), yyline, yychar);}
<YYINITIAL>{str} {return new PSymbol(sym.STR, yytext().substring(1, yytext().length() - 1), yyline, yychar);}

<YYINITIAL>"if" {return new PSymbol(sym.IF, yytext(), yyline, yychar);}
<YYINITIAL>"else" {return new PSymbol(sym.ELSE, yytext(), yyline, yychar);}
<YYINITIAL>"while" {return new PSymbol(sym.WHILE, yytext(), yyline, yychar);}
<YYINITIAL>"do" {return new PSymbol(sym.DO, yytext(), yyline, yychar);}
<YYINITIAL>"repeat" {return new PSymbol(sym.REPEAT, yytext(), yyline, yychar);}
<YYINITIAL>"until" {return new PSymbol(sym.UNTIL, yytext(), yyline, yychar);}
<YYINITIAL>"return" {return new PSymbol(sym.RETURN, yytext(), yyline, yychar);}
<YYINITIAL>"tdef" {return new PSymbol(sym.TDEF, yytext(), yyline, yychar);} 
<YYINITIAL>"fdef" {return new PSymbol(sym.FDEF, yytext(), yyline, yychar);}
<YYINITIAL>"in" {return new PSymbol(sym.IN, yytext(), yyline, yychar);}
<YYINITIAL>"not in" {return new PSymbol(sym.NOTIN, yytext(), yyline, yychar);}

<YYINITIAL>{id} {return new PSymbol(sym.ID, yytext(), yyline, yychar);}

<YYINITIAL>{whitespace} { }

<YYINITIAL>"/*" {yybegin(COMMENT);}
<COMMENT>"*/" {yybegin(YYINITIAL);}
<COMMENT>.|{whitespace} {}

<YYINITIAL>. {System.out.println(LexicalError.createLexicalErrorDescription(yytext(), yyline, yychar, "unknown character.")); LexicalError.increaseError();}









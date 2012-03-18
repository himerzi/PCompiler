package compiler;

import java_cup.runtime.Symbol;

class MySymbol extends Symbol {
  int tokenid;
  int line;


  MySymbol (int tokenid, int line) {
   super(tokenid);
   this.line = line;
  }

  MySymbol (int tokenid, Object value, int line) {
    super(tokenid, value);
	this.line = line;
  }

  int getLine() {
    return line;
  }
}
%%

%cup
%line
%state COMMENT
letter = [a-zA-Z]
digit = [0-9]

whitespace = [ \t\r\n\f]
boolean = true|false
boolop = "||"|&&
numop = "+"|-|"*"|/|"^"
comparison = <|<=|>|>=|!=|"||"
character = ({letter}|{digit}|{whitespace})
char = '{character}'
string = \"({character}*)\"
integer = {digit}+
float = {digit}+("."{digit}+)
identifier = {letter}+({letter}*{digit}*)*
type = bool|int|float|char|str|list|tuple
seqop = in|not{whitespace}in|::|({identifier}|{string})"["{integer}"]"|len"("({identifier}|{string})")"
number = {digit}+("."{digit}+)?

%%

<YYINITIAL>"if" {return new Symbol(sym.IF);}
<YYINITIAL>"while" {return new Symbol(sym.WHILE);}
<YYINITIAL>"else" {return new Symbol(sym.ELSE);}
<YYINITIAL>"do" {return new Symbol(sym.DO);}  
<YYINITIAL>"repeat" {return new Symbol(sym.REPEAT);}
<YYINITIAL>"until" {return new Symbol(sym.UNTIL);}
<YYINITIAL>"return" {return new Symbol(sym.RETURN);}
<YYINITIAL>"fdef" {return new Symbol(sym.FDEF);}
<YYINITIAL>"tdef" {return new Symbol(sym.TDEF);}
<YYINITIAL>"," { return new Symbol(sym.COMMA); }
<YYINITIAL>"." { return new Symbol(sym.DOT); }
<YYINITIAL>"[|" { return new Symbol(sym.BEGINTUP); }
<YYINITIAL>"|]" { return new Symbol(sym.ENDTUP); }
<YYINITIAL>"[" { return new Symbol(sym.LBRACK); }
<YYINITIAL>"]" { return new Symbol(sym.RBRACK); }
<YYINITIAL>"+" { return new Symbol(sym.PLUS); }
<YYINITIAL>"*" { return new Symbol(sym.TIMES); }
<YYINITIAL>"|" { return new Symbol(sym.PIPE); }
<YYINITIAL>"==" { return new Symbol(sym.EQQ); }
<YYINITIAL>"/" { return new Symbol(sym.DIV); }
<YYINITIAL>"=" { return new Symbol(sym.ASSIGN); }
<YYINITIAL>"^" { return new Symbol(sym.POW); }
<YYINITIAL>"(" { return new Symbol(sym.LPAREN); }
<YYINITIAL>")" { return new Symbol(sym.RPAREN); }
<YYINITIAL>"{" {return new Symbol(sym.LCURL);}
<YYINITIAL>"}" {return new Symbol(sym.RCURL);}
<YYINITIAL>";" { return new Symbol(sym.SEMI); }
<YYINITIAL>":" { return new Symbol(sym.COLON); }
<YYINITIAL>"!" { return new Symbol(sym.NOT); }
<YYINITIAL>{char} { return new Symbol(sym.CHAR, new Character((new String(yytext())).charAt(1))); }
<YYINITIAL>{string} { return new Symbol(sym.STRING, new String(yytext())); }
<YYINITIAL>{boolean} { return new Symbol(sym.BOOL, new Boolean(yytext())); }
<YYINITIAL>{number} { return new Symbol(sym.NUM, new String(yytext())); }
<YYINITIAL>{integer} { return new Symbol(sym.INT, new Integer(yytext())); }
<YYINITIAL>{float} { return new Symbol(sym.FLOAT, new Double(yytext())); }
<YYINITIAL>{boolop} { return new Symbol(sym.BOOLOP, new String(yytext())); }
<YYINITIAL>{numop} { return new Symbol(sym.NUMOP, new String(yytext())); }
<YYINITIAL>{seqop} { return new Symbol(sym.SEQOP, new String(yytext())); }
<YYINITIAL>{comparison} { return new Symbol(sym.COMPOP, new String(yytext())); }
<YYINITIAL>{type} { return new Symbol(sym.TYPE, new String(yytext()));}
<YYINITIAL>{identifier} { return new Symbol(sym.ID, new String(yytext())); }
<YYINITIAL>{whitespace} {}
<YYINITIAL>"/*" {yybegin(COMMENT);}
<COMMENT>. {}
<COMMENT>"*/" {yybegin(YYINITIAL);}
<YYINITIAL>. {System.err.println("Illegal character: " + yytext() + "found at line " + yyline);}
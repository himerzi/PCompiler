package compiler;
import PSymbol.*;
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


class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int COMMENT = 1;
	private final int yy_state_dtrans[] = {
		0,
		70
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NOT_ACCEPT,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NOT_ACCEPT,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NOT_ACCEPT,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NOT_ACCEPT,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NOT_ACCEPT,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NOT_ACCEPT,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"47:9,46:2,47,46:2,47:18,42,1,44,47:3,3,41,15,16,5,4,20,6,21,7,39,40:9,12,19" +
",9,10,11,47:2,43:26,17,47,18,8,47:2,29,22,30,38,36,28,43,31,25,43:2,24,43,2" +
"6,23,35,43,32,33,27,34,37,45,43:3,13,2,14,47:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,119,
"0,1,2,3,1:3,4,1,5,6,7,8,1:4,9,1:4,10,1:12,11,12:2,1,12,13,1,12:7,1,12:2,1:2" +
",13,14,15,16,17,18,19,20,21:2,22,23,1,24,25,11,26,27,28,29,30,31,32,33,34,3" +
"5,36,37,38,39,12,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,5" +
"9,60,61,62,12,63,64,65,66,67,68,69,70,71,72")[0];

	private int yy_nxt[][] = unpackFromString(73,48,
"1,2,3,55,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,108,109,56,110," +
"111,112,108,113,108,114,82,115,108,116,117,61,23,57,60,24,108,63,118,24,66," +
"-1:58,25,-1:39,26,-1:15,27,-1:34,29,-1:52,30,-1:47,31,-1:47,32,-1:49,33,-1:" +
"37,34,-1:67,108,83,108:15,84:2,-1:2,108,-1,108,-1:24,108:5,39,108:11,84:2,-" +
"1:2,108,-1,108,-1:24,108:17,84:2,-1:2,108,-1,108,-1:41,40:2,-1:10,28,-1:66," +
"108:4,35,108,36,108:10,84:2,-1:2,108,-1,108,-1:23,54,-1:17,57:2,-1:14,53,-1" +
":81,41,-1:28,59:19,-1,59:2,-1,59,-1:24,108,37,108:15,84:2,-1:2,108,-1,108,-" +
"1:24,62:19,-1,62:2,38,62,-1:24,108:10,39,108:6,84:2,-1:2,108,-1,108,-1:27,6" +
"8,-1:44,108:2,39,108:14,84:2,-1:2,108,-1,108,-1:28,49,-1:21,1,52:4,58,52:42" +
",-1:22,108:17,84:2,-1,65,108,-1,108,-1:24,108:14,42,108:2,84:2,-1:2,108,-1," +
"108,-1:24,108:6,43,108:10,84:2,-1:2,108,-1,108,-1:24,108:6,44,108:10,84:2,-" +
"1:2,108,-1,108,-1:24,108:14,45,108:2,84:2,-1:2,108,-1,108,-1:24,108:16,46,8" +
"4:2,-1:2,108,-1,108,-1:24,108:14,39,108:2,84:2,-1:2,108,-1,108,-1:24,108:2," +
"47,108:14,84:2,-1:2,108,-1,108,-1:24,108:14,48,108:2,84:2,-1:2,108,-1,108,-" +
"1:24,108:4,50,108:12,84:2,-1:2,108,-1,108,-1:24,108:5,51,108:11,84:2,-1:2,1" +
"08,-1,108,-1:24,108:5,64,108:11,84:2,-1:2,108,-1,108,-1:24,108,67,108:15,84" +
":2,-1:2,108,-1,108,-1:24,108:11,69,108:5,84:2,-1:2,108,-1,108,-1:24,108:5,7" +
"1,108:11,84:2,-1:2,108,-1,108,-1:24,108:12,72,108:4,84:2,-1:2,108,-1,108,-1" +
":24,108:13,99,108:3,84:2,-1:2,108,-1,108,-1:24,108:14,73,108:2,84:2,-1:2,10" +
"8,-1,108,-1:24,108,100,108:15,84:2,-1:2,108,-1,108,-1:24,108:2,101,108:14,8" +
"4:2,-1:2,108,-1,108,-1:24,108:14,74,108:2,84:2,-1:2,108,-1,108,-1:24,108:7," +
"64,108:9,84:2,-1:2,108,-1,108,-1:24,108:5,102,108:7,103,108:3,84:2,-1:2,108" +
",-1,108,-1:24,108:5,104,108:11,84:2,-1:2,108,-1,108,-1:24,108:11,75,108:5,8" +
"4:2,-1:2,108,-1,108,-1:24,108:3,76,108:13,84:2,-1:2,108,-1,108,-1:24,108:3," +
"105,108:13,84:2,-1:2,108,-1,108,-1:24,108:2,77,108:14,84:2,-1:2,108,-1,108," +
"-1:24,108:7,69,108:9,84:2,-1:2,108,-1,108,-1:24,108:11,72,108:5,84:2,-1:2,1" +
"08,-1,108,-1:24,108:12,106,108:4,84:2,-1:2,108,-1,108,-1:24,108:14,107,108:" +
"2,84:2,-1:2,108,-1,108,-1:24,108:3,78,108:13,84:2,-1:2,108,-1,108,-1:24,108" +
":2,79,108:14,84:2,-1:2,108,-1,108,-1:24,108:10,80,108:6,84:2,-1:2,108,-1,10" +
"8,-1:24,108:7,81,108:9,84:2,-1:2,108,-1,108,-1:24,108:3,85,108:13,84:2,-1:2" +
",108,-1,108,-1:24,108,86,108:15,84:2,-1:2,108,-1,108,-1:24,108:10,87,108,88" +
",108:3,89,84:2,-1:2,108,-1,108,-1:24,108:2,90,108:4,91,108:8,92,84:2,-1:2,1" +
"08,-1,108,-1:24,108:9,93,108:7,84:2,-1:2,108,-1,108,-1:24,108:14,94,108:2,8" +
"4:2,-1:2,108,-1,108,-1:24,108:4,95,108:12,84:2,-1:2,108,-1,108,-1:24,108:2," +
"96,108:14,84:2,-1:2,108,-1,108,-1:24,108,97,108:15,84:2,-1:2,108,-1,108,-1:" +
"24,108:9,98,108:7,84:2,-1:2,108,-1,108,-1:2");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{return new PSymbol(sym.NOT, yytext(), yyline, yychar);}
					case -3:
						break;
					case 3:
						{System.out.println(LexicalError.createLexicalErrorDescription(yytext(), yyline, yychar, "unknown character.")); LexicalError.increaseError();}
					case -4:
						break;
					case 4:
						{return new PSymbol(sym.PLUS, yytext(), yyline, yychar);}
					case -5:
						break;
					case 5:
						{return new PSymbol(sym.TIMES, yytext(), yyline, yychar);}
					case -6:
						break;
					case 6:
						{return new PSymbol(sym.MINUS, yytext(), yyline, yychar);}
					case -7:
						break;
					case 7:
						{return new PSymbol(sym.DIVIDE, yytext(), yyline, yychar);}
					case -8:
						break;
					case 8:
						{return new PSymbol(sym.POWER, yytext(), yyline, yychar);}
					case -9:
						break;
					case 9:
						{return new PSymbol(sym.LESS, yytext(), yyline, yychar);}
					case -10:
						break;
					case 10:
						{return new PSymbol(sym.EQ, yytext(), yyline, yychar);}
					case -11:
						break;
					case 11:
						{return new PSymbol(sym.GREATER, yytext(), yyline, yychar);}
					case -12:
						break;
					case 12:
						{return new PSymbol(sym.COLON, yytext(), yyline, yychar);}
					case -13:
						break;
					case 13:
						{return new PSymbol(sym.LCURL, yytext(), yyline, yychar);}
					case -14:
						break;
					case 14:
						{return new PSymbol(sym.RCURL, yytext(), yyline, yychar);}
					case -15:
						break;
					case 15:
						{return new PSymbol(sym.LPAREN, yytext(), yyline, yychar);}
					case -16:
						break;
					case 16:
						{return new PSymbol(sym.RPAREN, yytext(), yyline, yychar);}
					case -17:
						break;
					case 17:
						{return new PSymbol(sym.LBRAC, yytext(), yyline, yychar);}
					case -18:
						break;
					case 18:
						{return new PSymbol(sym.RBRAC, yytext(), yyline, yychar);}
					case -19:
						break;
					case 19:
						{return new PSymbol(sym.SEMI, yytext(), yyline, yychar);}
					case -20:
						break;
					case 20:
						{return new PSymbol(sym.COMMA, yytext(), yyline, yychar);}
					case -21:
						break;
					case 21:
						{return new PSymbol(sym.DOT, yytext(), yyline, yychar);}
					case -22:
						break;
					case 22:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -23:
						break;
					case 23:
						{return new PSymbol(sym.INT, new Integer(yytext()), yyline, yychar);}
					case -24:
						break;
					case 24:
						{ }
					case -25:
						break;
					case 25:
						{return new PSymbol(sym.NOTEQQ, yytext(), yyline, yychar);}
					case -26:
						break;
					case 26:
						{return new PSymbol(sym.OR, yytext(), yyline, yychar);}
					case -27:
						break;
					case 27:
						{return new PSymbol(sym.RTUPLE, yytext(), yyline, yychar);}
					case -28:
						break;
					case 28:
						{return new PSymbol(sym.AND, yytext(), yyline, yychar);}
					case -29:
						break;
					case 29:
						{yybegin(COMMENT);}
					case -30:
						break;
					case 30:
						{return new PSymbol(sym.LESSEQ, yytext(), yyline, yychar);}
					case -31:
						break;
					case 31:
						{return new PSymbol(sym.EQQ, yytext(), yyline, yychar);}
					case -32:
						break;
					case 32:
						{return new PSymbol(sym.GREATEREQ, yytext(), yyline, yychar);}
					case -33:
						break;
					case 33:
						{return new PSymbol(sym.CONCAT, yytext(), yyline, yychar);}
					case -34:
						break;
					case 34:
						{return new PSymbol(sym.LTUPLE, yytext(), yyline, yychar);}
					case -35:
						break;
					case 35:
						{return new PSymbol(sym.IN, yytext(), yyline, yychar);}
					case -36:
						break;
					case 36:
						{return new PSymbol(sym.IF, yytext(), yyline, yychar);}
					case -37:
						break;
					case 37:
						{return new PSymbol(sym.DO, yytext(), yyline, yychar);}
					case -38:
						break;
					case 38:
						{return new PSymbol(sym.STR, yytext().substring(1, yytext().length() - 1), yyline, yychar);}
					case -39:
						break;
					case 39:
						{return new PSymbol(sym.TYPE, yytext(), yyline, yychar);}
					case -40:
						break;
					case 40:
						{return new PSymbol(sym.FLOAT, new Float(yytext()), yyline, yychar);}
					case -41:
						break;
					case 41:
						{return new PSymbol(sym.CHAR, new Character(yytext().charAt(1)), yyline, yychar);}
					case -42:
						break;
					case 42:
						{return new PSymbol(sym.BOOL, yytext(), yyline, yychar);}
					case -43:
						break;
					case 43:
						{return new PSymbol(sym.TDEF, yytext(), yyline, yychar);}
					case -44:
						break;
					case 44:
						{return new PSymbol(sym.FDEF, yytext(), yyline, yychar);}
					case -45:
						break;
					case 45:
						{return new PSymbol(sym.ELSE, yytext(), yyline, yychar);}
					case -46:
						break;
					case 46:
						{return new PSymbol(sym.VOID, yytext(), yyline, yychar);}
					case -47:
						break;
					case 47:
						{return new PSymbol(sym.UNTIL, yytext(), yyline, yychar);}
					case -48:
						break;
					case 48:
						{return new PSymbol(sym.WHILE, yytext(), yyline, yychar);}
					case -49:
						break;
					case 49:
						{return new PSymbol(sym.NOTIN, yytext(), yyline, yychar);}
					case -50:
						break;
					case 50:
						{return new PSymbol(sym.RETURN, yytext(), yyline, yychar);}
					case -51:
						break;
					case 51:
						{return new PSymbol(sym.REPEAT, yytext(), yyline, yychar);}
					case -52:
						break;
					case 52:
						{}
					case -53:
						break;
					case 53:
						{yybegin(YYINITIAL);}
					case -54:
						break;
					case 55:
						{System.out.println(LexicalError.createLexicalErrorDescription(yytext(), yyline, yychar, "unknown character.")); LexicalError.increaseError();}
					case -55:
						break;
					case 56:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -56:
						break;
					case 57:
						{return new PSymbol(sym.INT, new Integer(yytext()), yyline, yychar);}
					case -57:
						break;
					case 58:
						{}
					case -58:
						break;
					case 60:
						{System.out.println(LexicalError.createLexicalErrorDescription(yytext(), yyline, yychar, "unknown character.")); LexicalError.increaseError();}
					case -59:
						break;
					case 61:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -60:
						break;
					case 63:
						{System.out.println(LexicalError.createLexicalErrorDescription(yytext(), yyline, yychar, "unknown character.")); LexicalError.increaseError();}
					case -61:
						break;
					case 64:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -62:
						break;
					case 66:
						{System.out.println(LexicalError.createLexicalErrorDescription(yytext(), yyline, yychar, "unknown character.")); LexicalError.increaseError();}
					case -63:
						break;
					case 67:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -64:
						break;
					case 69:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -65:
						break;
					case 71:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -66:
						break;
					case 72:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -67:
						break;
					case 73:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -68:
						break;
					case 74:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -69:
						break;
					case 75:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -70:
						break;
					case 76:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -71:
						break;
					case 77:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -72:
						break;
					case 78:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -73:
						break;
					case 79:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -74:
						break;
					case 80:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -75:
						break;
					case 81:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -76:
						break;
					case 82:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -77:
						break;
					case 83:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -78:
						break;
					case 84:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -79:
						break;
					case 85:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -80:
						break;
					case 86:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -81:
						break;
					case 87:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -82:
						break;
					case 88:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -83:
						break;
					case 89:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -84:
						break;
					case 90:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -85:
						break;
					case 91:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -86:
						break;
					case 92:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -87:
						break;
					case 93:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -88:
						break;
					case 94:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -89:
						break;
					case 95:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -90:
						break;
					case 96:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -91:
						break;
					case 97:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -92:
						break;
					case 98:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -93:
						break;
					case 99:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -94:
						break;
					case 100:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -95:
						break;
					case 101:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -96:
						break;
					case 102:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -97:
						break;
					case 103:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -98:
						break;
					case 104:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -99:
						break;
					case 105:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -100:
						break;
					case 106:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -101:
						break;
					case 107:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -102:
						break;
					case 108:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -103:
						break;
					case 109:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -104:
						break;
					case 110:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -105:
						break;
					case 111:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -106:
						break;
					case 112:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -107:
						break;
					case 113:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -108:
						break;
					case 114:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -109:
						break;
					case 115:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -110:
						break;
					case 116:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -111:
						break;
					case 117:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -112:
						break;
					case 118:
						{return new PSymbol(sym.ID, yytext(), yyline, yychar);}
					case -113:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}

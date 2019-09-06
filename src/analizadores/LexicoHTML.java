package analizadores;
import java_cup.runtime.Symbol;
import proyecto1.Reporte;


public class LexicoHTML implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;
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

	public LexicoHTML (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public LexicoHTML (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private LexicoHTML () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
 
    yyline = 1; 
    yychar = 1; 
	}

	private boolean yy_eof_done = false;
	private final int TEXTOETIQUETA = 1;
	private final int COMENTARIO_T = 3;
	private final int YYINITIAL = 0;
	private final int COMENTARIO = 2;
	private final int yy_state_dtrans[] = {
		0,
		18,
		21,
		23
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
		/* 25 */ YY_NOT_ACCEPT,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NOT_ACCEPT,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NOT_ACCEPT,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NOT_ACCEPT,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NOT_ACCEPT,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NOT_ACCEPT,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NOT_ACCEPT,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NOT_ACCEPT,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NOT_ACCEPT,
		/* 48 */ YY_NOT_ACCEPT,
		/* 49 */ YY_NOT_ACCEPT,
		/* 50 */ YY_NOT_ACCEPT,
		/* 51 */ YY_NOT_ACCEPT,
		/* 52 */ YY_NOT_ACCEPT,
		/* 53 */ YY_NOT_ACCEPT,
		/* 54 */ YY_NOT_ACCEPT,
		/* 55 */ YY_NOT_ACCEPT,
		/* 56 */ YY_NOT_ACCEPT,
		/* 57 */ YY_NOT_ACCEPT,
		/* 58 */ YY_NOT_ACCEPT,
		/* 59 */ YY_NOT_ACCEPT,
		/* 60 */ YY_NOT_ACCEPT,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NOT_ACCEPT,
		/* 63 */ YY_NOT_ACCEPT,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NOT_ACCEPT
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"22:9,25,23,22,26,24,22:18,27,20,28,22:10,21,22,2,22:12,4,3,1,22:2,10,12,22," +
"11,9,18,22,5,15,22:2,8,7,16,13,22:4,6,17,19,22:2,14,22:2,29,22:4,10,12,22,1" +
"1,9,18,22,5,15,22:2,8,7,16,13,22:4,6,17,19,22:2,14,22:65414,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,67,
"0,1:4,2,1,3,1:10,4,5,1,6,1,7,1,8,9,10,11,12,13,14,15,16,1,17,1,18,19,20,21," +
"22,23,24,11:2,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,4" +
"5")[0];

	private int yy_nxt[][] = unpackFromString(46,30,
"1,2,3,4,5,26,33,36:4,38,40,36:2,42,64,36:6,6,7,61,36,61,44,36,-1:35,25,-1:1" +
"4,32,-1:33,61,27,-1,61,-1:2,1,29:3,19,29:25,-1:20,57,-1:9,1,36,30:19,46,30:" +
"8,1,36,31:19,65,31:8,-1:6,63,-1:29,35,-1:2,37,-1:44,61:2,34,61,-1:3,45:22,-" +
"1,45:4,9,47,-1,29:3,-1,29:25,-1:2,30:19,-1,30:8,-1:2,31:19,-1,31:8,-1:21,48" +
",-1:23,62,-1:21,49,-1:32,50,-1:34,39,-1:33,10,-1:23,41,-1:27,51,-1:29,8,-1:" +
"35,52,-1:33,59,-1:9,45:22,-1,45:4,28,47,-1:21,11,-1:16,54,-1:32,12,-1:32,13" +
",-1:33,56,-1:19,14,-1:22,15,-1:37,16,-1:29,17,-1:41,58,-1:29,20,-1:9,22,-1:" +
"29,24,-1:52,61:2,-1,61,-1:8,66,-1:30,53,-1:35,43,-1:37,60,-1:16,55,-1:21");

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
						{yybegin(TEXTOETIQUETA); return new Symbol(sym1.mayor,yyline,yychar, yytext().trim().toLowerCase());}
					case -3:
						break;
					case 3:
						{return new Symbol(sym1.diagonal,yyline,yychar, yytext().trim().toLowerCase());}
					case -4:
						break;
					case 4:
						{return new Symbol(sym1.igual,yyline,yychar, yytext().trim().toLowerCase());}
					case -5:
						break;
					case 5:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -6:
						break;
					case 6:
						{yychar=1;}
					case -7:
						break;
					case 7:
						{}
					case -8:
						break;
					case 8:
						{return new Symbol(sym1.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -9:
						break;
					case 9:
						{return new Symbol(sym1.cadena,yyline,yychar, yytext().trim());}
					case -10:
						break;
					case 10:
						{return new Symbol(sym1.div,yyline,yychar, yytext().trim().toLowerCase());}
					case -11:
						break;
					case 11:
						{yybegin(COMENTARIO);}
					case -12:
						break;
					case 12:
						{return new Symbol(sym1.head,yyline,yychar, yytext().trim().toLowerCase());}
					case -13:
						break;
					case 13:
						{return new Symbol(sym1.body,yyline,yychar, yytext().trim().toLowerCase());}
					case -14:
						break;
					case 14:
						{return new Symbol(sym1.htmlI,yyline,yychar, yytext().trim().toLowerCase());}
					case -15:
						break;
					case 15:
						{return new Symbol(sym1.htmlF,yyline,yychar, yytext().trim().toLowerCase());}
					case -16:
						break;
					case 16:
						{return new Symbol(sym1.title,yyline,yychar, yytext().trim().toLowerCase());}
					case -17:
						break;
					case 17:
						{return new Symbol(sym1.noufe,yyline,yychar, yytext().trim().toLowerCase());}
					case -18:
						break;
					case 18:
						{return new Symbol(sym1.txtetiqueta,yyline,yychar, yytext().trim().toLowerCase()); }
					case -19:
						break;
					case 19:
						{yybegin(YYINITIAL);}
					case -20:
						break;
					case 20:
						{yybegin(COMENTARIO_T);}
					case -21:
						break;
					case 21:
						{}
					case -22:
						break;
					case 22:
						{yybegin(YYINITIAL);}
					case -23:
						break;
					case 23:
						{}
					case -24:
						break;
					case 24:
						{yybegin(TEXTOETIQUETA);}
					case -25:
						break;
					case 26:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -26:
						break;
					case 27:
						{}
					case -27:
						break;
					case 28:
						{return new Symbol(sym1.cadena,yyline,yychar, yytext().trim());}
					case -28:
						break;
					case 29:
						{return new Symbol(sym1.txtetiqueta,yyline,yychar, yytext().trim().toLowerCase()); }
					case -29:
						break;
					case 30:
						{}
					case -30:
						break;
					case 31:
						{}
					case -31:
						break;
					case 33:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -32:
						break;
					case 34:
						{}
					case -33:
						break;
					case 36:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -34:
						break;
					case 38:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -35:
						break;
					case 40:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -36:
						break;
					case 42:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -37:
						break;
					case 44:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -38:
						break;
					case 46:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -39:
						break;
					case 61:
						{}
					case -40:
						break;
					case 64:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -41:
						break;
					case 65:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[HTML] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -42:
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

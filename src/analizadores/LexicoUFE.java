package analizadores;
import proyecto1.Reporte;
import java_cup.runtime.Symbol;


public class LexicoUFE implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

String texto ="";
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

	public LexicoUFE (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public LexicoUFE (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private LexicoUFE () {
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
	private final int TEXTOETIQUETA = 4;
	private final int COMENTARIO_T = 5;
	private final int COMPONENTE = 1;
	private final int S3 = 7;
	private final int YYINITIAL = 0;
	private final int S2 = 6;
	private final int COMENTARIO = 3;
	private final int COMENTARIOH = 2;
	private final int yy_state_dtrans[] = {
		0,
		119,
		84,
		86,
		133,
		133,
		133,
		133
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
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
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
		/* 89 */ YY_NOT_ACCEPT,
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
		/* 101 */ YY_NOT_ACCEPT,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NOT_ACCEPT,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NOT_ACCEPT,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NOT_ACCEPT,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NOT_ACCEPT,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NOT_ACCEPT,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NOT_ACCEPT,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NOT_ACCEPT,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NOT_ACCEPT,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NO_ANCHOR,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NO_ANCHOR,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR,
		/* 150 */ YY_NO_ANCHOR,
		/* 151 */ YY_NO_ANCHOR,
		/* 152 */ YY_NO_ANCHOR,
		/* 153 */ YY_NO_ANCHOR,
		/* 154 */ YY_NO_ANCHOR,
		/* 155 */ YY_NO_ANCHOR,
		/* 156 */ YY_NO_ANCHOR,
		/* 157 */ YY_NO_ANCHOR,
		/* 158 */ YY_NO_ANCHOR,
		/* 159 */ YY_NO_ANCHOR,
		/* 160 */ YY_NO_ANCHOR,
		/* 161 */ YY_NO_ANCHOR,
		/* 162 */ YY_NO_ANCHOR,
		/* 163 */ YY_NO_ANCHOR,
		/* 164 */ YY_NO_ANCHOR,
		/* 165 */ YY_NO_ANCHOR,
		/* 166 */ YY_NO_ANCHOR,
		/* 167 */ YY_NO_ANCHOR,
		/* 168 */ YY_NO_ANCHOR,
		/* 169 */ YY_NO_ANCHOR,
		/* 170 */ YY_NO_ANCHOR,
		/* 171 */ YY_NO_ANCHOR,
		/* 172 */ YY_NO_ANCHOR,
		/* 173 */ YY_NO_ANCHOR,
		/* 174 */ YY_NO_ANCHOR,
		/* 175 */ YY_NO_ANCHOR,
		/* 176 */ YY_NO_ANCHOR,
		/* 177 */ YY_NO_ANCHOR,
		/* 178 */ YY_NO_ANCHOR,
		/* 179 */ YY_NO_ANCHOR,
		/* 180 */ YY_NO_ANCHOR,
		/* 181 */ YY_NO_ANCHOR,
		/* 182 */ YY_NO_ANCHOR,
		/* 183 */ YY_NO_ANCHOR,
		/* 184 */ YY_NO_ANCHOR,
		/* 185 */ YY_NO_ANCHOR,
		/* 186 */ YY_NO_ANCHOR,
		/* 187 */ YY_NO_ANCHOR,
		/* 188 */ YY_NO_ANCHOR,
		/* 189 */ YY_NO_ANCHOR,
		/* 190 */ YY_NO_ANCHOR,
		/* 191 */ YY_NO_ANCHOR,
		/* 192 */ YY_NO_ANCHOR,
		/* 193 */ YY_NO_ANCHOR,
		/* 194 */ YY_NO_ANCHOR,
		/* 195 */ YY_NO_ANCHOR,
		/* 196 */ YY_NO_ANCHOR,
		/* 197 */ YY_NO_ANCHOR,
		/* 198 */ YY_NO_ANCHOR,
		/* 199 */ YY_NO_ANCHOR,
		/* 200 */ YY_NO_ANCHOR,
		/* 201 */ YY_NO_ANCHOR,
		/* 202 */ YY_NO_ANCHOR,
		/* 203 */ YY_NO_ANCHOR,
		/* 204 */ YY_NO_ANCHOR,
		/* 205 */ YY_NO_ANCHOR,
		/* 206 */ YY_NO_ANCHOR,
		/* 207 */ YY_NO_ANCHOR,
		/* 208 */ YY_NO_ANCHOR,
		/* 209 */ YY_NO_ANCHOR,
		/* 210 */ YY_NO_ANCHOR,
		/* 211 */ YY_NO_ANCHOR,
		/* 212 */ YY_NO_ANCHOR,
		/* 213 */ YY_NO_ANCHOR,
		/* 214 */ YY_NO_ANCHOR,
		/* 215 */ YY_NO_ANCHOR,
		/* 216 */ YY_NO_ANCHOR,
		/* 217 */ YY_NO_ANCHOR,
		/* 218 */ YY_NO_ANCHOR,
		/* 219 */ YY_NO_ANCHOR,
		/* 220 */ YY_NO_ANCHOR,
		/* 221 */ YY_NO_ANCHOR,
		/* 222 */ YY_NO_ANCHOR,
		/* 223 */ YY_NO_ANCHOR,
		/* 224 */ YY_NO_ANCHOR,
		/* 225 */ YY_NO_ANCHOR,
		/* 226 */ YY_NO_ANCHOR,
		/* 227 */ YY_NO_ANCHOR,
		/* 228 */ YY_NO_ANCHOR,
		/* 229 */ YY_NO_ANCHOR,
		/* 230 */ YY_NO_ANCHOR,
		/* 231 */ YY_NO_ANCHOR,
		/* 232 */ YY_NO_ANCHOR,
		/* 233 */ YY_NO_ANCHOR,
		/* 234 */ YY_NO_ANCHOR,
		/* 235 */ YY_NO_ANCHOR,
		/* 236 */ YY_NO_ANCHOR,
		/* 237 */ YY_NO_ANCHOR,
		/* 238 */ YY_NO_ANCHOR,
		/* 239 */ YY_NO_ANCHOR,
		/* 240 */ YY_NO_ANCHOR,
		/* 241 */ YY_NO_ANCHOR,
		/* 242 */ YY_NO_ANCHOR,
		/* 243 */ YY_NO_ANCHOR,
		/* 244 */ YY_NO_ANCHOR,
		/* 245 */ YY_NO_ANCHOR,
		/* 246 */ YY_NO_ANCHOR,
		/* 247 */ YY_NO_ANCHOR,
		/* 248 */ YY_NO_ANCHOR,
		/* 249 */ YY_NO_ANCHOR,
		/* 250 */ YY_NO_ANCHOR,
		/* 251 */ YY_NO_ANCHOR,
		/* 252 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"37:9,40,38,37,41,39,37:18,42,25,45,37:3,26,49,3,4,32,30,7,31,44,33,43:10,37" +
",8,22,23,24,37:2,19,54,13,12,10,21,53,52,20,47,55,36,15,11,14,16,47,9,29,17" +
",35,18,34,50,51,47,5,46,6,28,48,37,19,54,13,12,10,21,53,52,20,47,55,36,15,1" +
"1,14,16,47,9,29,17,35,18,34,50,51,47,2,27,1,37:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,253,
"0,1:9,2,3,4,5,6,7,1:4,8,1,9,10,1:6,11,1:2,12:2,1,13,1,12:11,1:5,14,1:4,15,1" +
",16,1,17,18,14,1,15,1:2,14,1,14,19,14:10,20,1,21,22,1,23,24,25,26,27,28,29," +
"30,31,32,33,34,13,35,1:2,36,1,27,37,27,38,39,40,41,42,43,44,45,46,47,48,31," +
"49,50,51,52,53,31,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72," +
"73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97," +
"98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,1" +
"17,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135," +
"136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154" +
",155,156,157,158,159,160,161,12,162,163,164,165,166,167,168,169,170,171,172" +
",173,174,175,176,177")[0];

	private int yy_nxt[][] = unpackFromString(178,56,
"1,2,3,4,5,6,7,8,9,10,236:3,238,236,240,152,187,156,236,242,189,11,12,13,14," +
"15,91,16,90,17,18,19,20,236:3,103,21,22,153,103,153,23,103,109,103,236,103," +
"113,236:6,-1:65,236,213,236:11,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,2" +
"36:6,-1:23,24,-1:55,25,-1:55,26,-1:55,27,-1:58,28,-1:61,31,89,-1:61,153,92," +
"-1,153,-1:56,23,101,-1:20,236:2,120,236:10,-1:7,236,-1:4,236:3,-1:6,236,-1:" +
"3,236:2,-1,236:6,-1:9,236:13,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236" +
":6,-1:43,36,-1:21,54:13,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:43,6" +
"7,-1:44,68,123,-1:61,155,96,-1,155,-1:56,64,-1:21,54:12,235,-1:7,54,-1:4,54" +
":3,-1:6,54,-1:3,54:2,-1,54:6,1,99:31,125,103,99:22,1,100:31,87,103,100:22,-" +
"1:33,88,-1:23,89:37,35,94,89:16,-1:9,236:11,30,236,-1:7,236,-1:4,236:3,-1:6" +
",236,-1:3,236:2,-1,236:6,-1:27,29,-1:67,153:2,104,153,-1:14,107:37,-1,107:6" +
",32,111,107:9,-1:38,35,-1:26,54:3,65,54:2,196,54,165,54:4,-1:7,54,-1:4,54:3" +
",-1:6,54,-1:3,54:2,-1,54:6,-1:39,155:2,106,155,-1:14,127:37,-1,127:6,69,130" +
",127:9,-1:38,71,-1:18,99:31,-1:2,99:22,-1,100:31,-1:2,100:22,-1:9,236:13,-1" +
":7,236,-1:4,33,236:2,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,54,-1:4,5" +
"4:3,-1:6,54,-1:3,54:2,-1,65,54:5,-1:9,34,236:12,-1:7,236,-1:4,236:3,-1:6,23" +
"6,-1:3,236:2,-1,236:6,-1:9,54:2,65,54:10,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:" +
"2,-1,54:6,-1,107:37,-1,107:6,93,111,107:9,-1:9,236,38,236:11,-1:7,236,-1:4," +
"236:3,-1:6,236,-1:3,236:2,-1,236:6,-1,115:55,-1:9,54:13,-1:7,54,-1:4,70,54:" +
"2,-1:6,54,-1:3,54:2,-1,54:6,-1:49,37,-1:15,236:6,39,236:6,-1:7,236,-1:4,236" +
":3,-1:6,236,-1:3,236:2,-1,236:6,-1:8,66,-1:56,54:4,65,54:8,-1:7,54,-1:4,54:" +
"3,-1:6,54,-1:3,54:2,-1,54:6,1,49,50,51,117,52,53,103:2,54,251,54,247,214,24" +
"8,154,157,188,54:2,95,216,55,56,57,103:4,159,58,59,60,61,218,54,190,103,62," +
"63,155,103,155,64,103,121,103,54,103:2,65:2,237,54,239,54,-1:9,236:5,40,236" +
":7,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54,72,54:11,-1:7,5" +
"4,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1,123:37,71,98,123:16,-1:9,236,41,23" +
"6:11,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:33,85,-1:31,54:8,7" +
"3,54:4,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,42,236:12,-1:7,236," +
"-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:6,74,54:6,-1:7,54,-1:4,54:3" +
",-1:6,54,-1:3,54:2,-1,54:6,-1,127:37,-1,127:6,97,130,127:9,-1:9,236:2,43,23" +
"6:10,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:8,75,54:4,-1:" +
"7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,1,103:37,-1:2,103:16,-1:9,236:8,44" +
",236:4,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,65,54:12,-1:7," +
"54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,45,236:12,-1:7,236,-1:4,236:3,-" +
"1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,54,-1:4,54:2,76,-1:6,54,-1:3,54" +
":2,-1,54:6,-1:9,236:13,-1:7,46,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9" +
",54,77,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,47,236:12,-1:" +
"7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54,78,54:11,-1:7,54,-1:4" +
",54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:8,48,236:4,-1:7,236,-1:4,236:3,-1:" +
"6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1" +
",54:2,65,54:3,-1:9,54:8,65,54:4,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6" +
",-1:9,54:2,79,54:10,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:8,8" +
"0,54:4,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:13,-1:7,54,-1:4," +
"54:3,-1:6,54,-1:3,54:2,-1,54:5,65,-1:9,81,54:12,-1:7,54,-1:4,54:3,-1:6,54,-" +
"1:3,54:2,-1,54:6,-1:9,54:13,-1:7,82,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:" +
"9,54,65,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:3,83,54:9" +
",-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:5,102,236:7,-1:7,236," +
"-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:39,153:2,-1,153,-1:22,54:10,105," +
"110,54,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:39,155:2,-1,155,-1:22" +
",236:10,108,236:2,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:" +
"5,114,54:4,194,54:2,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:13" +
",-1:7,236,-1:4,236,112,236,-1:6,236,-1:3,236:2,-1,236:6,-1:9,118,54:6,244,5" +
"4:5,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:5,116,236:7,-1:7,2" +
"36,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,54,-1:4,54,122,5" +
"4,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:13,-1:7,124,-1:4,236:3,-1:6,236,-1:3,2" +
"36:2,-1,236:6,-1:9,54:13,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,126,54:5,-1" +
":9,236,128,236:11,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54," +
"129,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,131,236:12,-1:7," +
"236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,132,-1:4,54:3,-" +
"1:6,54,-1:3,54:2,-1,54:6,-1:9,134,236:12,-1:7,236,-1:4,236:3,-1:6,236,-1:3," +
"236:2,-1,236:6,-1:9,54:5,135,54:7,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54" +
":6,-1:9,236:11,136,236,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:" +
"9,54,137,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:10,138," +
"236:2,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,54,-" +
"1:4,54:3,-1:6,54,-1:3,54:2,-1,54:3,139,54:2,-1:9,236:11,140,236,-1:7,236,-1" +
":4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,141,-1:4,54:3,-1:6,54" +
",-1:3,54:2,-1,54:6,-1:9,236:2,142,236:10,-1:7,236,-1:4,236:3,-1:6,236,-1:3," +
"236:2,-1,236:6,-1:9,54:8,143,54:4,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54" +
":6,-1:9,54:13,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:2,144,54:3,-1:9,54," +
"135,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:5,145,54:7,-1" +
":7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:13,-1:7,54,-1:4,54:2,146," +
"-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:4,147,54:8,-1:7,54,-1:4,54:3,-1:6,54,-1:3" +
",54:2,-1,54:6,-1:9,54,148,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6" +
",-1:9,54:8,149,54:4,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:6,1" +
"50,54:6,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:13,-1:7,54,-1:4" +
",54:2,151,-1:6,54,-1:3,54:2,-1,54:6,-1:9,158,236:12,-1:7,236,-1:4,236:3,-1:" +
"6,236,-1:3,236:2,-1,236:6,-1:9,161,163,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3" +
",54:2,-1,54:6,-1:9,160,236:9,191,236:2,-1:7,236,-1:4,236:3,-1:6,236,-1:3,23" +
"6:2,-1,236:6,-1:9,54:11,167,54,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6," +
"-1:9,236:13,-1:7,236,-1:4,236:2,162,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13" +
",-1:7,54,-1:4,54:2,169,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:3,164,236:9,-1:7," +
"236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:2,171,54:10,-1:7,54,-1:" +
"4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:13,-1:7,236,-1:4,236,166,236,-1:6" +
",236,-1:3,236:2,-1,236:6,-1:9,54:10,173,54:2,-1:7,54,-1:4,54:3,-1:6,54,-1:3" +
",54:2,-1,54:6,-1:9,231,236:4,168,236:7,-1:7,236,-1:4,236:3,-1:6,236,-1:3,23" +
"6:2,-1,236:6,-1:9,54:13,-1:7,54,-1:4,54:2,175,-1:6,54,-1:3,54:2,-1,54:6,-1:" +
"9,236:8,170,236:4,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:" +
"3,177,54:9,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,172,236:12,-1:7" +
",236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,54,-1:4,54:3,-" +
"1:6,54,-1:3,54:2,-1,54:3,178,54:2,-1:9,236:6,174,236:6,-1:7,236,-1:4,236:3," +
"-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:3,179,54:9,-1:7,54,-1:4,54:3,-1:6,54,-" +
"1:3,54:2,-1,54:6,-1:9,236,176,236:11,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:" +
"2,-1,236:6,-1:9,54:8,180,54:4,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-" +
"1:9,54:13,-1:7,54,-1:4,54,181,54,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:11,182,5" +
"4,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:2,183,54:10,-1:7,54,-" +
"1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:2,184,54:10,-1:7,54,-1:4,54:3,-1" +
":6,54,-1:3,54:2,-1,54:6,-1:9,54:10,185,54:2,-1:7,54,-1:4,54:3,-1:6,54,-1:3," +
"54:2,-1,54:6,-1:9,54,186,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6," +
"-1:9,236:2,193,236:4,221,195,236:4,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2," +
"-1,236:6,-1:9,54:5,192,54:7,-1:7,54,-1:4,54:2,252,-1:6,54,-1:3,54:2,-1,54:6" +
",-1:9,236:6,223,236:6,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9" +
",54:10,198,54:2,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236,225,23" +
"6:11,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:11,200,54,-1:" +
"7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:7,197,236:5,-1:7,236,-1:4" +
",236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:11,202,54,-1:7,54,-1:4,54:3,-1:" +
"6,54,-1:3,54:2,-1,54:6,-1:9,236,199,236:11,-1:7,236,-1:4,236:3,-1:6,236,-1:" +
"3,236:2,-1,236:6,-1:9,204,54:12,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6" +
",-1:9,236:7,227,236:5,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9" +
",54:8,206,54:4,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:2,229,2" +
"36:10,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:10,207,54:2," +
"-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:5,233,236:7,-1:7,236,-" +
"1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:13,-1:7,54,-1:4,54:2,208,-1:" +
"6,54,-1:3,54:2,-1,54:6,-1:9,236:8,201,236:4,-1:7,236,-1:4,236:3,-1:6,236,-1" +
":3,236:2,-1,236:6,-1:9,54:2,209,54:10,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-" +
"1,54:6,-1:9,236:11,203,236,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6" +
",-1:9,54,210,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:2,2" +
"05,236:10,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:2,211,54" +
":10,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:11,212,54,-1:7,54,-" +
"1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54,220,54:11,-1:7,54,-1:4,54:3,-1:6" +
",54,-1:3,54:2,-1,54:6,-1:9,236:5,215,236:7,-1:7,236,-1:4,236:3,-1:6,236,-1:" +
"3,236:2,-1,236:6,-1:9,54:5,222,54:7,-1:7,54,-1:4,54,224,54,-1:6,54,-1:3,54:" +
"2,-1,54:6,-1:9,236:11,217,236,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,23" +
"6:6,-1:9,54:12,226,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,236:6,2" +
"19,236:6,-1:7,236,-1:4,236:3,-1:6,236,-1:3,236:2,-1,236:6,-1:9,54:4,228,54:" +
"8,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:11,230,54,-1:7,54,-1:" +
"4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:6,232,54:6,-1:7,54,-1:4,54:3,-1:6," +
"54,-1:3,54:2,-1,54:6,-1:9,54:13,-1:7,234,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:" +
"6,-1:9,54,241,54:11,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:2,2" +
"43,54:10,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54,245,54:11,-1:7" +
",54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6,-1:9,54:13,-1:7,246,-1:4,54:3,-1:6," +
"54,-1:3,54:2,-1,54:6,-1:9,54:13,-1:7,54,-1:4,54:2,249,-1:6,54,-1:3,54:2,-1," +
"54:6,-1:9,54:10,250,54:2,-1:7,54,-1:4,54:3,-1:6,54,-1:3,54:2,-1,54:6");

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
						{return new Symbol(sym3.llaveDer,yyline,yychar, yytext().trim().toLowerCase());}
					case -3:
						break;
					case 3:
						{return new Symbol(sym3.llaveIzq,yyline,yychar, yytext().trim().toLowerCase());}
					case -4:
						break;
					case 4:
						{return new Symbol(sym3.parentesisIzq,yyline,yychar, yytext().trim().toLowerCase());}
					case -5:
						break;
					case 5:
						{return new Symbol(sym3.parentesisDer,yyline,yychar, yytext().trim().toLowerCase());}
					case -6:
						break;
					case 6:
						{return new Symbol(sym3.corcheteIzq,yyline,yychar, yytext().trim().toLowerCase());}
					case -7:
						break;
					case 7:
						{return new Symbol(sym3.corcheteDer,yyline,yychar, yytext().trim().toLowerCase());}
					case -8:
						break;
					case 8:
						{return new Symbol(sym3.coma,yyline,yychar, yytext().trim().toLowerCase());}
					case -9:
						break;
					case 9:
						{return new Symbol(sym3.pyc,yyline,yychar, yytext().trim().toLowerCase());}
					case -10:
						break;
					case 10:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -11:
						break;
					case 11:
						{return new Symbol(sym3.menor,yyline,yychar, yytext().trim().toLowerCase());}
					case -12:
						break;
					case 12:
						{return new Symbol(sym3.igual,yyline,yychar, yytext().trim().toLowerCase());}
					case -13:
						break;
					case 13:
						{return new Symbol(sym3.mayor,yyline,yychar, yytext().trim().toLowerCase());}
					case -14:
						break;
					case 14:
						{return new Symbol(sym3.negacion,yyline,yychar, yytext().trim().toLowerCase());}
					case -15:
						break;
					case 15:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[UFE] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -16:
						break;
					case 16:
						{return new Symbol(sym3.xor,yyline,yychar, yytext().trim().toLowerCase());}
					case -17:
						break;
					case 17:
						{return new Symbol(sym3.mas,yyline,yychar, yytext().trim().toLowerCase());}
					case -18:
						break;
					case 18:
						{return new Symbol(sym3.menos,yyline,yychar, yytext().trim().toLowerCase());}
					case -19:
						break;
					case 19:
						{return new Symbol(sym3.multi,yyline,yychar, yytext().trim().toLowerCase());}
					case -20:
						break;
					case 20:
						{return new Symbol(sym3.division,yyline,yychar, yytext().trim().toLowerCase());}
					case -21:
						break;
					case 21:
						{yychar=1;}
					case -22:
						break;
					case 22:
						{}
					case -23:
						break;
					case 23:
						{return new Symbol(sym3.numeroentero,yyline,yychar, yytext().trim().toLowerCase());}
					case -24:
						break;
					case 24:
						{return new Symbol(sym3.menorigual,yyline,yychar, yytext().trim().toLowerCase());}
					case -25:
						break;
					case 25:
						{return new Symbol(sym3.igualdad,yyline,yychar, yytext().trim().toLowerCase());}
					case -26:
						break;
					case 26:
						{return new Symbol(sym3.mayorigual,yyline,yychar, yytext().trim().toLowerCase());}
					case -27:
						break;
					case 27:
						{return new Symbol(sym3.diferente,yyline,yychar, yytext().trim().toLowerCase());}
					case -28:
						break;
					case 28:
						{return new Symbol(sym3.and,yyline,yychar, yytext().trim().toLowerCase());}
					case -29:
						break;
					case 29:
						{return new Symbol(sym3.or,yyline,yychar, yytext().trim().toLowerCase());}
					case -30:
						break;
					case 30:
						{return new Symbol(sym3.si,yyline,yychar, yytext().trim().toLowerCase());}
					case -31:
						break;
					case 31:
						{yybegin(COMENTARIO);}
					case -32:
						break;
					case 32:
						{return new Symbol(sym3.p_cadena,yyline,yychar, yytext().trim());}
					case -33:
						break;
					case 33:
						{return new Symbol(sym3.pow,yyline,yychar, yytext().trim().toLowerCase());}
					case -34:
						break;
					case 34:
						{return new Symbol(sym3.var,yyline,yychar, yytext().trim().toLowerCase());}
					case -35:
						break;
					case 35:
						{}
					case -36:
						break;
					case 36:
						{return new Symbol(sym3.numerodecimal,yyline,yychar, yytext().trim().toLowerCase());}
					case -37:
						break;
					case 37:
						{return new Symbol(sym3.p_char,yyline,yychar, yytext().trim().toLowerCase());}
					case -38:
						break;
					case 38:
						{return new Symbol(sym3.p_true,yyline,yychar, yytext().trim().toLowerCase());}
					case -39:
						break;
					case 39:
						{return new Symbol(sym3.from,yyline,yychar, yytext().trim().toLowerCase());}
					case -40:
						break;
					case 40:
						{return new Symbol(sym3.sino,yyline,yychar, yytext().trim().toLowerCase());}
					case -41:
						break;
					case 41:
						{return new Symbol(sym3.p_false,yyline,yychar, yytext().trim().toLowerCase());}
					case -42:
						break;
					case 42:
						{return new Symbol(sym3.render,yyline,yychar, yytext().trim().toLowerCase());}
					case -43:
						break;
					case 43:
						{yybegin(COMPONENTE); return new Symbol(sym3.inicioReturn,yyline,yychar, yytext().trim().toLowerCase());}
					case -44:
						break;
					case 44:
						{return new Symbol(sym3.p_import,yyline,yychar, yytext().trim().toLowerCase());}
					case -45:
						break;
					case 45:
						{return new Symbol(sym3.repetir,yyline,yychar, yytext().trim().toLowerCase());}
					case -46:
						break;
					case 46:
						{return new Symbol(sym3.mientras,yyline,yychar, yytext().trim().toLowerCase());}
					case -47:
						break;
					case 47:
						{return new Symbol(sym3.imprimir,yyline,yychar, yytext().trim().toLowerCase());}
					case -48:
						break;
					case 48:
						{return new Symbol(sym3.component,yyline,yychar, yytext().trim().toLowerCase());}
					case -49:
						break;
					case 49:
						{return new Symbol(sym3.llaveDer,yyline,yychar, yytext().trim().toLowerCase());}
					case -50:
						break;
					case 50:
						{return new Symbol(sym3.llaveIzq,yyline,yychar, yytext().trim().toLowerCase());}
					case -51:
						break;
					case 51:
						{return new Symbol(sym3.parentesisIzq,yyline,yychar, yytext().trim().toLowerCase());}
					case -52:
						break;
					case 52:
						{return new Symbol(sym3.corcheteIzq,yyline,yychar, yytext().trim().toLowerCase());}
					case -53:
						break;
					case 53:
						{return new Symbol(sym3.corcheteDer,yyline,yychar, yytext().trim().toLowerCase());}
					case -54:
						break;
					case 54:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -55:
						break;
					case 55:
						{return new Symbol(sym3.etiquetaA,yyline,yychar, yytext().trim().toLowerCase());}
					case -56:
						break;
					case 56:
						{return new Symbol(sym3.igual,yyline,yychar, yytext().trim().toLowerCase());}
					case -57:
						break;
					case 57:
						{return new Symbol(sym3.etiquetaC,yyline,yychar, yytext().trim().toLowerCase());}
					case -58:
						break;
					case 58:
						{return new Symbol(sym3.mas,yyline,yychar, yytext().trim().toLowerCase());}
					case -59:
						break;
					case 59:
						{return new Symbol(sym3.menos,yyline,yychar, yytext().trim().toLowerCase());}
					case -60:
						break;
					case 60:
						{return new Symbol(sym3.multi,yyline,yychar, yytext().trim().toLowerCase());}
					case -61:
						break;
					case 61:
						{return new Symbol(sym3.diagonal,yyline,yychar, yytext().trim().toLowerCase());}
					case -62:
						break;
					case 62:
						{yychar=1;}
					case -63:
						break;
					case 63:
						{}
					case -64:
						break;
					case 64:
						{return new Symbol(sym3.numeroentero,yyline,yychar, yytext().trim().toLowerCase());}
					case -65:
						break;
					case 65:
						{ return new Symbol(sym3.atributo,yyline,yychar, yytext().trim().toLowerCase());}
					case -66:
						break;
					case 66:
						{yybegin(YYINITIAL); return new Symbol(sym3.finReturn,yyline,yychar, yytext().trim().toLowerCase());}
					case -67:
						break;
					case 67:
						{return new Symbol(sym3.numeronegativo,yyline,yychar, yytext().trim().toLowerCase());}
					case -68:
						break;
					case 68:
						{yybegin(COMENTARIOH);}
					case -69:
						break;
					case 69:
						{return new Symbol(sym3.p_cadena,yyline,yychar, yytext().trim());}
					case -70:
						break;
					case 70:
						{return new Symbol(sym3.pow,yyline,yychar, yytext().trim().toLowerCase());}
					case -71:
						break;
					case 71:
						{}
					case -72:
						break;
					case 72:
						{return new Symbol(sym3.p_true,yyline,yychar, yytext().trim().toLowerCase());}
					case -73:
						break;
					case 73:
						{return new Symbol(sym3.text,yyline,yychar, yytext().trim().toLowerCase());}
					case -74:
						break;
					case 74:
						{return new Symbol(sym3.item,yyline,yychar, yytext().trim().toLowerCase());}
					case -75:
						break;
					case 75:
						{return new Symbol(sym3.list,yyline,yychar, yytext().trim().toLowerCase());}
					case -76:
						break;
					case 76:
						{return new Symbol(sym3.panel,yyline,yychar, yytext().trim().toLowerCase());}
					case -77:
						break;
					case 77:
						{return new Symbol(sym3.image,yyline,yychar, yytext().trim().toLowerCase());}
					case -78:
						break;
					case 78:
						{return new Symbol(sym3.p_false,yyline,yychar, yytext().trim().toLowerCase());}
					case -79:
						break;
					case 79:
						{return new Symbol(sym3.boton,yyline,yychar, yytext().trim().toLowerCase());}
					case -80:
						break;
					case 80:
						{return new Symbol(sym3.p_default,yyline,yychar, yytext().trim().toLowerCase());}
					case -81:
						break;
					case 81:
						{return new Symbol(sym3.spinner,yyline,yychar, yytext().trim().toLowerCase());}
					case -82:
						break;
					case 82:
						{return new Symbol(sym3.elements,yyline,yychar, yytext().trim().toLowerCase());}
					case -83:
						break;
					case 83:
						{return new Symbol(sym3.textfield,yyline,yychar, yytext().trim().toLowerCase());}
					case -84:
						break;
					case 84:
						{}
					case -85:
						break;
					case 85:
						{yybegin(COMPONENTE);}
					case -86:
						break;
					case 86:
						{}
					case -87:
						break;
					case 87:
						{}
					case -88:
						break;
					case 88:
						{yybegin(YYINITIAL);}
					case -89:
						break;
					case 90:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -90:
						break;
					case 91:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[UFE] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -91:
						break;
					case 92:
						{}
					case -92:
						break;
					case 93:
						{return new Symbol(sym3.p_cadena,yyline,yychar, yytext().trim());}
					case -93:
						break;
					case 94:
						{}
					case -94:
						break;
					case 95:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -95:
						break;
					case 96:
						{}
					case -96:
						break;
					case 97:
						{return new Symbol(sym3.p_cadena,yyline,yychar, yytext().trim());}
					case -97:
						break;
					case 98:
						{}
					case -98:
						break;
					case 99:
						{}
					case -99:
						break;
					case 100:
						{}
					case -100:
						break;
					case 102:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -101:
						break;
					case 103:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[UFE] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -102:
						break;
					case 104:
						{}
					case -103:
						break;
					case 105:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -104:
						break;
					case 106:
						{}
					case -105:
						break;
					case 108:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -106:
						break;
					case 109:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[UFE] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -107:
						break;
					case 110:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -108:
						break;
					case 112:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -109:
						break;
					case 113:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[UFE] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -110:
						break;
					case 114:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -111:
						break;
					case 116:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -112:
						break;
					case 117:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[UFE] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -113:
						break;
					case 118:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -114:
						break;
					case 120:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -115:
						break;
					case 121:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[UFE] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -116:
						break;
					case 122:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -117:
						break;
					case 124:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -118:
						break;
					case 125:
						{
            Reporte.agregarReporte(new Reporte("Lexico", "[UFE] caracter malo: "+yytext().trim().toLowerCase(),yyline,yychar));
}
					case -119:
						break;
					case 126:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -120:
						break;
					case 128:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -121:
						break;
					case 129:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -122:
						break;
					case 131:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -123:
						break;
					case 132:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -124:
						break;
					case 134:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -125:
						break;
					case 135:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -126:
						break;
					case 136:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -127:
						break;
					case 137:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -128:
						break;
					case 138:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -129:
						break;
					case 139:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -130:
						break;
					case 140:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -131:
						break;
					case 141:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -132:
						break;
					case 142:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -133:
						break;
					case 143:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -134:
						break;
					case 144:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -135:
						break;
					case 145:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -136:
						break;
					case 146:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -137:
						break;
					case 147:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -138:
						break;
					case 148:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -139:
						break;
					case 149:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -140:
						break;
					case 150:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -141:
						break;
					case 151:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -142:
						break;
					case 152:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -143:
						break;
					case 153:
						{}
					case -144:
						break;
					case 154:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -145:
						break;
					case 155:
						{}
					case -146:
						break;
					case 156:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -147:
						break;
					case 157:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -148:
						break;
					case 158:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -149:
						break;
					case 159:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -150:
						break;
					case 160:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -151:
						break;
					case 161:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -152:
						break;
					case 162:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -153:
						break;
					case 163:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -154:
						break;
					case 164:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -155:
						break;
					case 165:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -156:
						break;
					case 166:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -157:
						break;
					case 167:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -158:
						break;
					case 168:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -159:
						break;
					case 169:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -160:
						break;
					case 170:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -161:
						break;
					case 171:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -162:
						break;
					case 172:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -163:
						break;
					case 173:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -164:
						break;
					case 174:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -165:
						break;
					case 175:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -166:
						break;
					case 176:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -167:
						break;
					case 177:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -168:
						break;
					case 178:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -169:
						break;
					case 179:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -170:
						break;
					case 180:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -171:
						break;
					case 181:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -172:
						break;
					case 182:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -173:
						break;
					case 183:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -174:
						break;
					case 184:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -175:
						break;
					case 185:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -176:
						break;
					case 186:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -177:
						break;
					case 187:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -178:
						break;
					case 188:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -179:
						break;
					case 189:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -180:
						break;
					case 190:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -181:
						break;
					case 191:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -182:
						break;
					case 192:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -183:
						break;
					case 193:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -184:
						break;
					case 194:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -185:
						break;
					case 195:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -186:
						break;
					case 196:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -187:
						break;
					case 197:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -188:
						break;
					case 198:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -189:
						break;
					case 199:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -190:
						break;
					case 200:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -191:
						break;
					case 201:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -192:
						break;
					case 202:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -193:
						break;
					case 203:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -194:
						break;
					case 204:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -195:
						break;
					case 205:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -196:
						break;
					case 206:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -197:
						break;
					case 207:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -198:
						break;
					case 208:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -199:
						break;
					case 209:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -200:
						break;
					case 210:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -201:
						break;
					case 211:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -202:
						break;
					case 212:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -203:
						break;
					case 213:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -204:
						break;
					case 214:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -205:
						break;
					case 215:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -206:
						break;
					case 216:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -207:
						break;
					case 217:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -208:
						break;
					case 218:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -209:
						break;
					case 219:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -210:
						break;
					case 220:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -211:
						break;
					case 221:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -212:
						break;
					case 222:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -213:
						break;
					case 223:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -214:
						break;
					case 224:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -215:
						break;
					case 225:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -216:
						break;
					case 226:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -217:
						break;
					case 227:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -218:
						break;
					case 228:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -219:
						break;
					case 229:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -220:
						break;
					case 230:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -221:
						break;
					case 231:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -222:
						break;
					case 232:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -223:
						break;
					case 233:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -224:
						break;
					case 234:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -225:
						break;
					case 235:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -226:
						break;
					case 236:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -227:
						break;
					case 237:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -228:
						break;
					case 238:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -229:
						break;
					case 239:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -230:
						break;
					case 240:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -231:
						break;
					case 241:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -232:
						break;
					case 242:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -233:
						break;
					case 243:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -234:
						break;
					case 244:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -235:
						break;
					case 245:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -236:
						break;
					case 246:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -237:
						break;
					case 247:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -238:
						break;
					case 248:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -239:
						break;
					case 249:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -240:
						break;
					case 250:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -241:
						break;
					case 251:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -242:
						break;
					case 252:
						{return new Symbol(sym3.id,yyline,yychar, yytext().trim().toLowerCase());}
					case -243:
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

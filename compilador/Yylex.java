/* The following code was generated by JFlex 1.6.0 */

/*AQUI PUEDEN IR LOS IMPORTS */

import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.0
 * from the specification file <tt>/home/fede/Escritorio/compiladores/compilador/src/compilador/Lexer.lex</tt>
 */
public class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\54\1\54\1\55\1\54\1\54\22\0\1\53\1\15\1\0"+
    "\2\4\1\14\1\51\1\4\1\44\1\45\1\12\1\11\1\40\1\1"+
    "\1\5\1\13\1\2\10\2\1\2\1\4\1\41\1\7\1\10\1\6"+
    "\2\4\1\3\30\3\1\3\1\46\1\0\1\47\1\0\2\4\1\22"+
    "\1\16\1\26\1\35\1\21\1\33\1\3\1\37\1\31\1\3\1\25"+
    "\1\20\1\3\1\23\1\17\2\3\1\24\1\27\1\30\1\32\1\34"+
    "\1\36\1\50\1\3\1\3\1\42\1\52\1\43\1\4\6\0\1\55"+
    "\u1fa2\0\1\55\1\55\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\11\4\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\2\5"+
    "\1\26\1\27\1\30\1\31\1\0\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\11\4\1\40\5\4\1\41\1\42"+
    "\1\43\10\4\1\44\1\45\6\4\1\46\4\4\1\47"+
    "\2\4\1\50\2\4\1\51\3\4\1\52\1\53\1\54"+
    "\1\55\2\4\1\56\1\4\1\57\3\4\1\60\3\4"+
    "\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\270\0\56\0\346\0\u0114"+
    "\0\u0142\0\u0170\0\56\0\u019e\0\56\0\u01cc\0\u01fa\0\u0228"+
    "\0\u0256\0\u0284\0\u02b2\0\u02e0\0\u030e\0\u033c\0\u036a\0\56"+
    "\0\56\0\56\0\56\0\56\0\56\0\56\0\56\0\u0398"+
    "\0\u03c6\0\56\0\56\0\56\0\56\0\u03f4\0\56\0\56"+
    "\0\56\0\56\0\56\0\56\0\u0422\0\u0450\0\u047e\0\u04ac"+
    "\0\u04da\0\u0508\0\u0536\0\u0564\0\u0592\0\270\0\u05c0\0\u05ee"+
    "\0\u061c\0\u064a\0\u0678\0\56\0\56\0\u03f4\0\u06a6\0\u06d4"+
    "\0\u0702\0\u0730\0\u075e\0\u078c\0\u07ba\0\u07e8\0\270\0\270"+
    "\0\u0816\0\u0844\0\u0872\0\u08a0\0\u08ce\0\u08fc\0\270\0\u092a"+
    "\0\u0958\0\u0986\0\u09b4\0\270\0\u09e2\0\u0a10\0\270\0\u0a3e"+
    "\0\u0a6c\0\270\0\u0a9a\0\u0ac8\0\u0af6\0\270\0\270\0\270"+
    "\0\270\0\u0b24\0\u0b52\0\270\0\u0b80\0\270\0\u0bae\0\u0bdc"+
    "\0\u0c0a\0\270\0\u0c38\0\u0c66\0\u0c94\0\270";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\2\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\2\5\1\20"+
    "\2\5\1\21\1\5\1\22\1\5\1\23\1\24\1\5"+
    "\1\25\1\26\1\5\1\27\1\5\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\5\1\40\1\41"+
    "\1\42\1\43\1\44\60\0\1\4\5\0\1\45\47\0"+
    "\1\4\2\0\1\46\52\0\2\5\12\0\22\5\10\0"+
    "\1\5\15\0\1\47\55\0\1\50\55\0\1\51\55\0"+
    "\1\52\60\0\1\53\52\0\1\54\47\0\2\5\12\0"+
    "\1\5\1\55\4\5\1\56\13\5\10\0\1\5\7\0"+
    "\2\5\12\0\2\5\1\57\17\5\10\0\1\60\7\0"+
    "\2\5\12\0\3\5\1\61\16\5\10\0\1\5\7\0"+
    "\2\5\12\0\1\5\1\62\1\63\17\5\10\0\1\5"+
    "\7\0\2\5\12\0\6\5\1\64\13\5\10\0\1\5"+
    "\7\0\2\5\12\0\5\5\1\65\7\5\1\66\4\5"+
    "\10\0\1\5\7\0\2\5\12\0\1\5\1\67\1\70"+
    "\1\5\1\71\15\5\10\0\1\5\7\0\2\5\12\0"+
    "\1\5\1\72\20\5\10\0\1\5\7\0\2\5\12\0"+
    "\21\5\1\73\10\0\1\5\56\0\1\74\56\0\1\75"+
    "\5\0\1\76\55\0\2\5\12\0\1\5\1\77\20\5"+
    "\10\0\1\5\7\0\2\5\12\0\3\5\1\100\16\5"+
    "\10\0\1\5\7\0\2\5\12\0\11\5\1\101\10\5"+
    "\10\0\1\5\7\0\2\5\12\0\12\5\1\102\7\5"+
    "\10\0\1\5\7\0\2\5\12\0\12\5\1\103\7\5"+
    "\10\0\1\5\7\0\2\5\12\0\5\5\1\104\14\5"+
    "\10\0\1\5\7\0\2\5\12\0\4\5\1\105\15\5"+
    "\10\0\1\5\7\0\2\5\12\0\14\5\1\106\5\5"+
    "\10\0\1\5\7\0\2\5\12\0\12\5\1\107\7\5"+
    "\10\0\1\5\7\0\2\5\12\0\6\5\1\110\13\5"+
    "\10\0\1\5\7\0\2\5\12\0\1\5\1\111\20\5"+
    "\10\0\1\5\7\0\2\5\12\0\2\5\1\112\17\5"+
    "\10\0\1\5\7\0\2\5\12\0\13\5\1\113\6\5"+
    "\10\0\1\5\7\0\2\5\12\0\13\5\1\114\6\5"+
    "\10\0\1\5\7\0\2\5\12\0\2\5\1\115\17\5"+
    "\10\0\1\5\7\0\2\5\12\0\4\5\1\116\15\5"+
    "\10\0\1\5\7\0\2\5\12\0\3\5\1\117\16\5"+
    "\10\0\1\5\7\0\2\5\12\0\3\5\1\120\16\5"+
    "\10\0\1\5\7\0\2\5\12\0\14\5\1\121\5\5"+
    "\10\0\1\5\7\0\2\5\12\0\12\5\1\122\7\5"+
    "\10\0\1\5\7\0\2\5\12\0\11\5\1\123\10\5"+
    "\10\0\1\5\7\0\2\5\12\0\3\5\1\124\16\5"+
    "\10\0\1\5\7\0\2\5\12\0\4\5\1\125\15\5"+
    "\10\0\1\5\7\0\2\5\12\0\11\5\1\126\10\5"+
    "\10\0\1\5\7\0\2\5\12\0\17\5\1\127\2\5"+
    "\10\0\1\5\7\0\2\5\12\0\2\5\1\130\17\5"+
    "\10\0\1\5\7\0\2\5\12\0\3\5\1\131\16\5"+
    "\10\0\1\5\7\0\2\5\12\0\7\5\1\132\12\5"+
    "\10\0\1\5\7\0\2\5\12\0\6\5\1\133\13\5"+
    "\10\0\1\5\7\0\2\5\12\0\6\5\1\134\13\5"+
    "\10\0\1\5\7\0\2\5\12\0\13\5\1\135\6\5"+
    "\10\0\1\5\7\0\2\5\12\0\11\5\1\136\10\5"+
    "\10\0\1\5\7\0\2\5\12\0\12\5\1\137\7\5"+
    "\10\0\1\5\7\0\2\5\12\0\3\5\1\140\16\5"+
    "\10\0\1\5\7\0\2\5\12\0\3\5\1\141\16\5"+
    "\10\0\1\5\7\0\2\5\12\0\4\5\1\142\15\5"+
    "\10\0\1\5\7\0\2\5\12\0\5\5\1\143\14\5"+
    "\10\0\1\5\7\0\2\5\12\0\5\5\1\144\14\5"+
    "\10\0\1\5\7\0\2\5\12\0\5\5\1\145\14\5"+
    "\10\0\1\5\7\0\2\5\12\0\5\5\1\146\14\5"+
    "\10\0\1\5\7\0\2\5\12\0\4\5\1\147\15\5"+
    "\10\0\1\5\7\0\2\5\12\0\14\5\1\150\5\5"+
    "\10\0\1\5\7\0\2\5\12\0\2\5\1\151\17\5"+
    "\10\0\1\5\7\0\2\5\12\0\3\5\1\152\16\5"+
    "\10\0\1\5\7\0\2\5\12\0\13\5\1\153\6\5"+
    "\10\0\1\5\7\0\2\5\12\0\5\5\1\154\14\5"+
    "\10\0\1\5\7\0\2\5\12\0\16\5\1\155\3\5"+
    "\10\0\1\5\7\0\2\5\12\0\7\5\1\156\12\5"+
    "\10\0\1\5\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3266];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\4\1\1\11\1\1\1\11"+
    "\12\1\10\11\2\1\4\11\1\0\6\11\17\1\2\11"+
    "\61\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
/*CODIGO USUARIO*/


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Yylex(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 180) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;           
    int totalRead = 0;
    while (totalRead < requested) {
      int numRead = zzReader.read(zzBuffer, zzEndRead + totalRead, requested - totalRead);
      if (numRead == -1) {
        break;
      }
      totalRead += numRead;
    }

    if (totalRead > 0) {
      zzEndRead += totalRead;
      if (totalRead == requested) { /* possibly more input available */
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      return false;
    }

    // totalRead = 0: End of stream
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { System.out.println("error");
          }
        case 50: break;
        case 2: 
          { return new Symbol(sym.resta, yychar, yyline, yytext());
          }
        case 51: break;
        case 3: 
          { return new Symbol(sym.int_literal, yychar, yyline, yytext());
          }
        case 52: break;
        case 4: 
          { return new Symbol(sym.id, yychar, yyline, yytext());
          }
        case 53: break;
        case 5: 
          { return new Symbol(sym.string_literal, yychar, yyline, yytext());
          }
        case 54: break;
        case 6: 
          { return new Symbol(sym.mayor, yychar, yyline, yytext());
          }
        case 55: break;
        case 7: 
          { return new Symbol(sym.menor, yychar, yyline, yytext());
          }
        case 56: break;
        case 8: 
          { return new Symbol(sym.asignacion, yychar, yyline, yytext());
          }
        case 57: break;
        case 9: 
          { return new Symbol(sym.suma, yychar, yyline, yytext());
          }
        case 58: break;
        case 10: 
          { return new Symbol(sym.multiplicacion, yychar, yyline, yytext());
          }
        case 59: break;
        case 11: 
          { return new Symbol(sym.division, yychar, yyline, yytext());
          }
        case 60: break;
        case 12: 
          { return new Symbol(sym.porcentaje, yychar, yyline, yytext());
          }
        case 61: break;
        case 13: 
          { return new Symbol(sym.admiracion, yychar, yyline, yytext());
          }
        case 62: break;
        case 14: 
          { return new Symbol(sym.coma, yychar, yyline, yytext());
          }
        case 63: break;
        case 15: 
          { return new Symbol(sym.punto_y_coma, yychar, yyline, yytext());
          }
        case 64: break;
        case 16: 
          { return new Symbol(sym.llave_izq, yychar, yyline, yytext());
          }
        case 65: break;
        case 17: 
          { return new Symbol(sym.llave_der, yychar, yyline, yytext());
          }
        case 66: break;
        case 18: 
          { return new Symbol(sym.parentesis_izq, yychar, yyline, yytext());
          }
        case 67: break;
        case 19: 
          { return new Symbol(sym.parentesis_der, yychar, yyline, yytext());
          }
        case 68: break;
        case 20: 
          { return new Symbol(sym.corchete_izq, yychar, yyline, yytext());
          }
        case 69: break;
        case 21: 
          { return new Symbol(sym.corchete_der, yychar, yyline, yytext());
          }
        case 70: break;
        case 22: 
          { return new Symbol(sym.espacio, yychar, yyline, yytext());
          }
        case 71: break;
        case 23: 
          { 
          }
        case 72: break;
        case 24: 
          { System.out.print(yytext());
          }
        case 73: break;
        case 25: 
          { return new Symbol(sym.decremento, yychar, yyline, yytext());
          }
        case 74: break;
        case 26: 
          { return new Symbol(sym.mayor_igual, yychar, yyline, yytext());
          }
        case 75: break;
        case 27: 
          { return new Symbol(sym.menor_igual, yychar, yyline, yytext());
          }
        case 76: break;
        case 28: 
          { return new Symbol(sym.igualdad_logica, yychar, yyline, yytext());
          }
        case 77: break;
        case 29: 
          { return new Symbol(sym.incremento, yychar, yyline, yytext());
          }
        case 78: break;
        case 30: 
          { return new Symbol(sym.comentario_simple, yychar, yyline, yytext());
          }
        case 79: break;
        case 31: 
          { return new Symbol(sym.diferencia_logica, yychar, yyline, yytext());
          }
        case 80: break;
        case 32: 
          { return new Symbol(sym.if, yychar, yyline, yytext());
          }
        case 81: break;
        case 33: 
          { return new Symbol(sym.conjuncion, yychar, yyline, yytext());
          }
        case 82: break;
        case 34: 
          { return new Symbol(sym.disyuncion, yychar, yyline, yytext());
          }
        case 83: break;
        case 35: 
          { return new Symbol(sym.float_literal, yychar, yyline, yytext());
          }
        case 84: break;
        case 36: 
          { return new Symbol(sym.int, yychar, yyline, yytext());
          }
        case 85: break;
        case 37: 
          { return new Symbol(sym.for, yychar, yyline, yytext());
          }
        case 86: break;
        case 38: 
          { return new Symbol(sym.else, yychar, yyline, yytext());
          }
        case 87: break;
        case 39: 
          { return new Symbol(sym.true, yychar, yyline, yytext());
          }
        case 88: break;
        case 40: 
          { return new Symbol(sym.void, yychar, yyline, yytext());
          }
        case 89: break;
        case 41: 
          { return new Symbol(sym.break, yychar, yyline, yytext());
          }
        case 90: break;
        case 42: 
          { return new Symbol(sym.class, yychar, yyline, yytext());
          }
        case 91: break;
        case 43: 
          { return new Symbol(sym.float, yychar, yyline, yytext());
          }
        case 92: break;
        case 44: 
          { return new Symbol(sym.false, yychar, yyline, yytext());
          }
        case 93: break;
        case 45: 
          { return new Symbol(sym.while, yychar, yyline, yytext());
          }
        case 94: break;
        case 46: 
          { return new Symbol(sym.return, yychar, yyline, yytext());
          }
        case 95: break;
        case 47: 
          { return new Symbol(sym.boolean, yychar, yyline, yytext());
          }
        case 96: break;
        case 48: 
          { return new Symbol(sym.continue, yychar, yyline, yytext());
          }
        case 97: break;
        case 49: 
          { return new Symbol(sym.externalinvk, yychar, yyline, yytext());
          }
        case 98: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {  return new Symbol(sym.EOF, new String("Fin Del Archivo"));
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java Yylex [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Yylex scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Yylex(reader);
          while ( !scanner.zzAtEOF ) scanner.next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}

package lexer;

import java.io.FileInputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Lexer implementation, given an input tokenizes it's content.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class TinyLexer {
  private Reader input; // Input reader
  private StringBuffer lexeme; // Stores the lexeme if exists
  private int nextChar; // Character that should be parsed next
  private int initRow; // Row the current token started in
  private int initCol; // Column the current token started in
  private int currentRow; // Row the current token is in
  private int currentCol; // Column the current token is in
  private static String lineBreak = System.getProperty("line.separator"); // Line break symbol

  // Possible states the lexer can be in
  private static enum State {
    INIT, R_LINT, R_DOT, R_LDEC, R_EXP, R_SIGN, R_LEXP, R_POP, R_PCL, R_AMP, R_SPROG, R_ID,
    R_PLUS, R_MINUS, R_MUL, R_DIV, R_IS, R_GT, R_LT, R_NOT, R_EQ, R_GEQ, R_LEQ, R_NEQ, R_EOL, R_EOF
  }

  private State state; // Lexer current state

  /**
   * Constructor.
   * An input must be given in order to tokenize.
   *
   * @param input Input the lexer will use
   * @throws IOException if can't read from the given input
   */
  public TinyLexer (Reader input) throws IOException {
    this.input = input;
    this.lexeme = new StringBuffer();
    this.nextChar = this.input.read();
    this.currentRow=1;
    this.currentCol=1;
  }

  /**
   * Tokenizes the next 'word' in the input.
   *
   * @return LexicalItem representing the lexed input
   * @throws IOException if can't read from the given input
   */
  public LexicalItem nextToken() throws IOException {
    this.state = State.INIT;
    this.initRow = this.currentRow;
    this.initCol = this.currentCol;
    this.lexeme.delete(0, this.lexeme.length());

    while(true) {
        switch(this.state) {
          case INIT:
            if (this.isLetter()) {
              this.transit(State.R_ID);
            } else if (this.isDigit()) {
              this.transit(State.R_LINT);
            } else if (this.isAmpersand()) {
              this.transit(State.R_AMP);
            } else if (this.isPlus()) {
              this.transit(State.R_PLUS);
            } else if (this.isMinus()) {
              this.transit(State.R_MINUS);
            } else if (this.isMul()) {
              this.transit(State.R_MUL);
            } else if (this.isDiv()) {
              this.transit(State.R_DIV);
            } else if (this.isEq()) {
              this.transit(State.R_IS);
            } else if (this.isGT()) {
              this.transit(State.R_GT);
            } else if (this.isLT()) {
              this.transit(State.R_LT);
            } else if (this.isNot()) {
              this.transit(State.R_NOT);
            } else if (this.isPOp()) {
              this.transit(State.R_POP);
            } else if (this.isPCl()) {
              this.transit(State.R_PCL);
            } else if (this.isSep()) {
              this.transitIgnoring(State.INIT);
            } else if (this.isEOL()) {
              this.transit(State.R_EOL);
            } else if (this.isEOF()) {
              this.transit(State.R_EOF);
            } else {
              this.error();
            }
            break;
          case R_ID:
            if (this.isLetterOrDigit()) {
              this.transit(State.R_ID);
            } else {
              return this.itemId();
            }
            break;
          case R_LINT:
            if (this.isDigit()) {
              this.transit(State.R_LINT);
            } else if (this.isDot()) {
              this.transit(State.R_DOT);
            } else if (this.isExp()) {
              this.transit(State.R_EXP);
            } else {
              return this.itemNumber();
            }
            break;
          case R_DOT:
            if (this.isDigit()) {
              this.transit(State.R_LDEC);
            } else {
              this.error();
            }
            break;
          case R_LDEC:
            if (this.isDigit()) {
              this.transit(State.R_LDEC);
            } else if (this.isExp()) {
              this.transit(State.R_EXP);
            } else {
              return this.itemNumber();
            }
            break;
          case R_EXP:
            if (this.isDigit()) {
              this.transit(State.R_LEXP);
            } else if (this.isSign()) {
              this.transit(State.R_SIGN);
            } else {
              this.error();
            }
            break;
          case R_SIGN:
            if (this.isDigit()) {
              this.transit(State.R_LEXP);
            } else {
              this.error();
            }
            break;
          case R_LEXP:
            if (this.isDigit()) {
              this.transit(State.R_LEXP);
            } else {
              return this.itemNumber();
            }
            break;
          case R_AMP:
            if (this.isAmpersand()) {
              this.transit(State.R_SPROG);
            } else {
              this.error();
            }
            break;
          case R_SPROG:
            return this.itemSPROG();
          case R_PLUS:
            if (this.isDigit()) {
              this.transit(State.R_LINT);
            } else {
              return this.itemPlus();
            }
            break;
          case R_MINUS:
            if (this.isDigit()) {
              this.transit(State.R_LINT);
            } else {
              return this.itemMinus();
            }
            break;
          case R_MUL:
            return this.itemMul();
          case R_DIV:
            return this.itemDiv();
          case R_IS:
            if (this.isEq()) {
              this.transit(State.R_EQ);
            } else {
              return this.itemIS();
            }
            break;
          case R_EQ:
            return this.itemEQ();
          case R_GT:
            if (this.isEq()) {
              this.transit(State.R_GEQ);
            } else {
              return this.itemGT();
            }
            break;
          case R_GEQ:
            return this.itemGEQ();
          case R_LT:
            if (this.isEq()) {
              this.transit(State.R_LEQ);
            } else {
              return this.itemLT();
            }
            break;
          case R_LEQ:
            return this.itemLEQ();
          case R_NOT:
            if (this.isEq()) {
              this.transit(State.R_NEQ);
            } else {
              this.error();
            }
            break;
          case R_NEQ:
            return this.itemNEQ();
          case R_POP:
            return this.itemPOp();
          case R_PCL:
            return this.itemPCl();
          case R_EOL:
            return this.itemEOL();
          case R_EOF:
            return this.itemEOF();
        }
    }
  }

  /**
   * Sets current state to nextState, appends processed character to the lexeme and
   * gets nextChar value from input.
   *
   * @throws IOException if can't read from the given input
   */
  private void transit(State nextState) throws IOException {
    this.lexeme.append((char) this.nextChar);
    this.nextChar();
    this.state = nextState;
  }

  /**
   * Sets current state to nextState and gets nextChar value from input.
   *
   * @throws IOException if can't read from the given input
   */
  private void transitIgnoring(State nextState) throws IOException {
    this.nextChar();
    this.initRow = this.currentRow; // why here but not in transit()?
    this.initCol = this.currentCol;
    this.state = nextState;
  }

  /**
   * Gets the next character from the input and stores it in nextChar,
   * also moves current row and column if necessary.
   *
   * @throws IOException if can't read from the given input
   */
  private void nextChar() throws IOException {
    this.nextChar = input.read();
    if (this.nextChar == this.lineBreak.charAt(0)) {
      lineBreak();
    }
    if (this.nextChar == '\n') {
      this.currentRow++;
      this.currentCol = 0;
    } else {
      this.currentCol++;
    }
  }

  /**
   * Reads all the characters in the input corresponding to line break in the current system and
   * sets nextChar to '\n' (the line break in our lexer)
   *
   * @throws IOException if can't read from the given input
   */
  private void lineBreak() throws IOException {
    for (int i=1; i < this.lineBreak.length(); i++) {
      this.nextChar = this.input.read();
      if (this.nextChar != this.lineBreak.charAt(i)) {
        this.error();
      }
    }
    this.nextChar = '\n';
  }

  /**
   * Checks if nextChar is a '&'.
   *
   * @return true if nextChar is a '&'
   */
  private boolean isAmpersand() {
    return this.nextChar == '&';
  }

  /**
   * Checks if nextChar is a letter, a letter is considered any ASCII char in range [a..z]
   * or [A..Z].
   *
   * @return true if nextChar is a letter
   */
  private boolean isLetter() {
    return (this.nextChar >= 'a' && this.nextChar <= 'z') || (this.nextChar >= 'A' && this.nextChar <= 'Z');
  }

  /**
   * Checks if nextChar is a decimal digit.
   *
   * @return true if nextChar is a decimal digit
   */
  private boolean isDigit() {
    return this.nextChar >= '0' && this.nextChar <= '9';
  }

  /**
   * Checks if nextChar is a leter, digit or underscore.
   * Where:
   *  A letter is any ASCII char between [a..z] or [A..Z].
   *  A digit is considered any decimal digit, [0..9]
   *
   * @return true if nextChar is a leter, digit or underscore
   */
  private boolean isLetterOrDigit() {
    return this.isLetter() || this.isDigit() || this.nextChar == '_';
  }

  /**
   * Checks if nextChar is plus symbol.
   *
   * @return true if nextChar is plus symbol
   */
  private boolean isPlus() {
    return this.nextChar == '+';
  }

  /**
   * Checks if nextChar is minus symbol.
   *
   * @return true if nextChar is minus symbol
   */
  private boolean isMinus() {
    return this.nextChar == '-';
  }

  /**
   * Checks if nextChar is multiplication symbol.
   *
   * @return true if nextChar is multiplication symbol
   */
  private boolean isMul() {
    return this.nextChar == '*';
  }

  /**
   * Checks if nextChar is division symbol.
   *
   * @return true if nextChar is plus symbol
   */
  private boolean isDiv() {
    return this.nextChar == '/';
  }

  /**
   * Checks if nextChar is opening parenthesis symbol.
   *
   * @return true if nextChar is opening parenthesis symbol
   */
  private boolean isPOp() {
    return this.nextChar == '(';
  }

  /**
   * Checks if nextChar is closing parenthesis symbol.
   *
   * @return true if nextChar is closing parenthesis symbol
   */
  private boolean isPCl() {
    return this.nextChar == ')';
  }

  /**
   * Checks if nextChar is equal symbol.
   *
   * @return true if nextChar is equal symbol
   */
  private boolean isEq() {
    return this.nextChar == '=';
  }

  /**
   * Checks if nextChar is greater than symbol.
   *
   * @return true if nextChar is greater then symbol
   */
  private boolean isGT() {
    return this.nextChar == '>';
  }
  /**
   * Checks if nextChar is lower than symbol.
   *
   * @return true if nextChar is lower than symbol
   */
  private boolean isLT() {
    return this.nextChar == '<';
  }
  /**
   * Checks if nextChar is '!'.
   *
   * @return true if nextChar is '!'
   */
  private boolean isNot() {
    return this.nextChar == '!';
  }

  /**
   * Checks if nextChar is dot symbol.
   *
   * @return true if nextChar is dot symbol
   */
  private boolean isDot() {
    return this.nextChar == '.';
  }

  /**
   * Checks if nextChar is e or E.
   *
   * @return true if nextChar is e or E
   */
  private boolean isExp() {
    return this.nextChar == 'e' || this.nextChar == 'E';
  }

  /**
   * Checks if nextChar is plus or minus symbol.
   *
   * @return true if nextChar is plus or minus symbol
   */
  private boolean isSign() {
    return this.isPlus() || this.isMinus();
  }

  /**
   * Checks if nextChar is separator symbol.
   * Where blankspace (' '), tab ('\t') and newline ('\n') are considered separators.
   *
   * @return true if nextChar is separator symbol
   */
  private boolean isSep() {
    return this.nextChar == ' ' || this.nextChar == '\t' || this.nextChar == '\n';
  }

  /**
   * Checks if nextChar is linebreak symbol.
   * Where newline ('\n'), carrige return ('\r') and backspace ('\b')
   * are considered linebreak symbols.
   *
   * @return true if nextChar is linebreak symbol
   */
  /*private boolean isLinebreak() {
    return this.nextChar == '\r' || this.nextChar == '\b' || this.nextChar == '\n';
  }*/

  /**
   * Checks if nextChar is end-of-line symbol, ;.
   *
   * @return true if nextChar is EOL symbol
   */
  private boolean isEOL() {
    return this.nextChar == ';';
  }

  /**
   * Checks if nextChar is end-of-file symbol.
   *
   * @return true if nextChar is EOF symbol
   */
  private boolean isEOF() {
    return this.nextChar == -1;
  }

  /**
   * Returns a lexical item representing the program section separator, '&&'.
   *
   * @return SPROG token
   */
  private LexicalItem itemSPROG() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.SPROG);
  }

  /**
   * Returns a lexical item representing a number.
   *
   * @return LREAL token
   */
  private LexicalItem itemNumber() {
    return new MultiLexicalItem(this.initRow, this.initCol, Lexicon.LREAL, this.lexeme.toString());
  }

  /**
   * Checks if the lexeme is any of the reserved words or just a simple id, case sensitive.
   *
   * @return Token corresponding to the lexeme
   */
  private LexicalItem itemId() {
    String lexemerep = this.lexeme.toString();
    switch(lexemerep) {
      case "bool":
        return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.BOOL);
      case "num":
        return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.NUM);
      case "true":
        return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.TRUE);
      case "false":
        return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.FALSE);
      case "and":
        return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.AND);
      case "or":
        return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.OR);
      case "not":
        return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.NOT);
      default:
        return new MultiLexicalItem(this.initRow, this.initCol, Lexicon.ID, lexemerep);
    }
  }

  /**
   * Returns a lexical item representing the plus operator.
   *
   * @return Plus token
   */
  private LexicalItem itemPlus() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.PLUS);
  }

  /**
   * Returns a lexical item representing the minus operator.
   *
   * @return Minus token
   */
  private LexicalItem itemMinus() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.MINUS);
  }

  /**
   * Returns a lexical item representing the multiplication operator.
   *
   * @return Multiplication token
   */
  private LexicalItem itemMul() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.MUL);
  }

  /**
   * Returns a lexical item representing the division operator.
   *
   * @return Division token
   */
  private LexicalItem itemDiv() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.DIV);
  }

  /**
   * Returns a lexical item representing the asignment, single equal.
   *
   * @return Asignment token
   */
  private LexicalItem itemIS() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.IS);
  }

  /**
   * Returns a lexical item representing the comparison, double equal.
   *
   * @return Comparison token
   */
  private LexicalItem itemEQ() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.EQ);
  }

  /**
   * Returns a lexical item representing the greater than comparison.
   *
   * @return Greater than token
   */
  private LexicalItem itemGT() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.GT);
  }

  /**
   * Returns a lexical item representing the greater or equal to comparison.
   *
   * @return Greater or equal to token
   */
  private LexicalItem itemGEQ() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.GEQ);
  }

  /**
   * Returns a lexical item representing the lower than comparison.
   *
   * @return Lower than token
   */
  private LexicalItem itemLT() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.LT);
  }

  /**
   * Returns a lexical item representing the lower or equal to comparison.
   *
   * @return Lower or equal to token
   */
  private LexicalItem itemLEQ() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.LEQ);
  }

  /**
   * Returns a lexical item representing the not equal comparison, !=.
   *
   * @return Not equal to token
   */
  private LexicalItem itemNEQ() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.NEQ);
  }

  /**
   * Returns a lexical item representing the opening parenthesis.
   *
   * @return Opening parenthesis token
   */
  private LexicalItem itemPOp() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.POP);
  }

  /**
   * Returns a lexical item representing the closing parenthesis.
   *
   * @return Closing parenthesis token
   */
  private LexicalItem itemPCl() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.PCL);
  }

  /**
   * Returns a lexical item representing the 'end-of-file'.
   *
   * @return EOF token
   */
  private LexicalItem itemEOL() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.EOL);
  }

  /**
   * Returns a lexical item representing the 'end-of-file'.
   *
   * @return EOF token
   */
  private LexicalItem itemEOF() {
    return new SingleLexicalItem(this.initRow, this.initCol, Lexicon.EOF);
  }

  private void error() {
    System.err.println("***("+this.currentRow+','+this.currentCol+") Unexpected character: " + this.lexeme);
    System.exit(1);
  }

  /**
   * Instantiates the input to read from some file, creates the lexer and loops until EOF token.
   */
  public static void main(String[] arg) throws IOException {
    Reader input = new InputStreamReader(new FileInputStream("input.txt"));
    TinyLexer lexer = new TinyLexer(input);
    LexicalItem token;

    do {
      token = lexer.nextToken();
      System.out.println(token);
    }
    while (token.getType() != Lexicon.EOF);
  }
}

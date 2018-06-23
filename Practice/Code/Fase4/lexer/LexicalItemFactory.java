package lexer;

import parser.Lexicon;
import errors.ErrorManager;

/**
 * Lexical items factory, will create lexical items for all the Lexicon.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class LexicalItemFactory {
  private TinyLexer lexer;

  /**
   * Constructor.
   * Stores the given TinyLexer to access get methods.
   *
   * @param lexer Instantiated TinyLexer
   */
  public LexicalItemFactory(TinyLexer lexer) {
    this.lexer = lexer;
  }

  /**
   * Generates a LexicalItem for the given item.
   *
   * @param item String representation of the desired lexical item
   * @return Lexical item that represents the given string
   */
  public LexicalItem getItem(String item) throws IllegalArgumentException {
    switch (item) {
    case "LREAL":
      return new LexicalItem(this.lexer.getRow(), Lexicon.LREAL, this.lexer.getLexeme());
    case "ID":
      return new LexicalItem(this.lexer.getRow(), Lexicon.ID, this.lexer.getLexeme());
    case "NUM":
      return new LexicalItem(this.lexer.getRow(), Lexicon.NUM, "num");
    case "BOOL":
      return new LexicalItem(this.lexer.getRow(), Lexicon.BOOL, "bool");
    case "TRUE":
      return new LexicalItem(this.lexer.getRow(), Lexicon.TRUE, "true");
    case "FALSE":
      return new LexicalItem(this.lexer.getRow(), Lexicon.FALSE, "false");
    case "AND":
      return new LexicalItem(this.lexer.getRow(), Lexicon.AND, "and");
    case "OR":
      return new LexicalItem(this.lexer.getRow(), Lexicon.OR, "or");
    case "NOT":
      return new LexicalItem(this.lexer.getRow(), Lexicon.NOT, "not");
    case "PLUS":
      return new LexicalItem(this.lexer.getRow(), Lexicon.PLUS, "+");
    case "MINUS":
      return new LexicalItem(this.lexer.getRow(), Lexicon.MINUS, "-");
    case "MUL":
      return new LexicalItem(this.lexer.getRow(), Lexicon.MUL, "*");
    case "DIV":
      return new LexicalItem(this.lexer.getRow(), Lexicon.DIV, "/");
    case "IS":
      return new LexicalItem(this.lexer.getRow(), Lexicon.IS, "=");
    case "EQ":
      return new LexicalItem(this.lexer.getRow(), Lexicon.EQ, "==");
    case "GT":
      return new LexicalItem(this.lexer.getRow(), Lexicon.GT, ">");
    case "GEQ":
      return new LexicalItem(this.lexer.getRow(), Lexicon.GEQ, ">=");
    case "LT":
      return new LexicalItem(this.lexer.getRow(), Lexicon.LT, "<");
    case "LEQ":
      return new LexicalItem(this.lexer.getRow(), Lexicon.LEQ, "<=");
    case "NEQ":
      return new LexicalItem(this.lexer.getRow(), Lexicon.NEQ, "!=");
    case "PCL":
      return new LexicalItem(this.lexer.getRow(), Lexicon.PCL, ")");
    case "POP":
      return new LexicalItem(this.lexer.getRow(), Lexicon.POP, "(");
    case "SPROG":
      return new LexicalItem(this.lexer.getRow(), Lexicon.SPROG, "&&");
    case "EOL":
      return new LexicalItem(this.lexer.getRow(), Lexicon.EOL, ";");
    case "EOF":
      return new LexicalItem(this.lexer.getRow(), Lexicon.EOF, "<EOF>");
    default:
      throw new IllegalArgumentException("Invalid item type: " + item);
    }
  }
}
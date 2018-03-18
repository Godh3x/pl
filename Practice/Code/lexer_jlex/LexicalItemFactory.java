package lexer_jlex;

import lexer_jlex.Lexicon;
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
      return new MultiLexicalItem(this.lexer.getRow(), Lexicon.LREAL, this.lexer.getLexeme());
    case "ID":
      return new MultiLexicalItem(this.lexer.getRow(), Lexicon.ID, this.lexer.getLexeme());
    case "NUM":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.NUM);
    case "BOOL":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.BOOL);
    case "TRUE":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.TRUE);
    case "FALSE":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.FALSE);
    case "AND":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.AND);
    case "OR":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.OR);
    case "NOT":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.NOT);
    case "PLUS":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.PLUS);
    case "MINUS":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.MINUS);
    case "MUL":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.MUL);
    case "DIV":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.DIV);
    case "IS":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.IS);
    case "EQ":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.EQ);
    case "GT":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.GT);
    case "GEQ":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.GEQ);
    case "LT":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.LT);
    case "LEQ":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.LEQ);
    case "NEQ":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.NEQ);
    case "PCL":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.PCL);
    case "POP":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.POP);
    case "SPROG":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.SPROG);
    case "EOL":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.EOL);
    case "EOF":
      return new SingleLexicalItem(this.lexer.getRow(), Lexicon.EOF);
    default:
      throw new IllegalArgumentException("Invalid item type: " + item);
    }
  }
}
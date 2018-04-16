package lexer_jlex;

import java_cup.runtime.Symbol;

/**
 * Abstract representation of a lexical item, every lexical item stores the row
 * where it appears.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class LexicalItem extends Symbol {
  private int row; // Row the item appears in

  /**
   * Constructor
   * Class and row must be specified for every new item.
   *
   * @param row Row the item appears in
   * @param type Class the item represents
   */
  public LexicalItem(int row, int type, String lexeme) {
    super(type, lexeme);
    this.row = row;
  }

  /**
   * Returns the actual lexicon type of the invoking item.
   *
   * @return
   */
  public Lexicon getType() {
    return this.sym;
  }

  /**
   * Returns the row of code where the invoking item is.
   *
   * @return row of code where the invoking item is
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Returns the string representation of the items content.
   *
   * @return string representation of the items content
   */
  public String getLexeme() {
    return (String)this.value;
  }

  /**
   * Returns the string representation of the invoking item.
   *
   * @return string representation of the invoking item
   */
  public abstract String toString() {
    this.getLexeme();
  }
}

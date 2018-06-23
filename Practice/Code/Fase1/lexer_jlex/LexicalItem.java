package lexer_jlex;

/**
 * Abstract representation of a single lexical item, every lexical item stores the row
 * where it appears.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public abstract class LexicalItem {
  private Lexicon type; // Actual class of the lexical item
  private int row; // Row the item appears in

  /**
   * Constructor
   * Class and row must be specified for every new item.
   *
   * @param row Row the item appears in
   * @param type Class the item represents
   */
  public LexicalItem(int row, Lexicon type) {
    this.row = row;
    this.type = type;
  }

  /**
   * Returns the actual lexicon type of the invoking item.
   *
   * @return
   */
  public Lexicon getType() {
    return this.type;
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
  public abstract String getLexeme();

  /**
   * Returns the string representation of the invoking item.
   *
   * @return string representation of the invoking item
   */
  public abstract String toString();
}

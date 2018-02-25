package lexer;

/**
 * Abstract representation of a single lexical item, every lexical item stores the row and column
 * where it appears.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public abstract class LexicalItem {
  private Lexicon type; // Actual class of the lexical item
  private int row; // Row the item appears in
  private int col; // Column the item appears in

  /**
   * Constructor
   * Class, row and col must be specified for every new item.
   *
   * @param row Row the item appears in
   * @param col Column the item appears in
   * @param type Class the item represents
   */
  public LexicalItem(int row, int col, Lexicon type) {
    this.row = row;
    this.col = col;
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
   * Returns the column of code where the invoking item is.
   *
   * @return column of code where the invoking item is
   */
  public int getCol() {
    return this.col;
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

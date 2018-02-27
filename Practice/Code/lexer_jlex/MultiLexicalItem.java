package lexer_jlex;

/**
 * Represents a multivaluated lexical item, this means the item is not defined univocally
 * by it's class so there is a lexeme that contains the value.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class MultiLexicalItem extends LexicalItem {
  private String lexeme; // Value that defines the item

  /**
   * Constructor
   * Row, col, class and lexeme must be specified for every new item.
   *
   * @param row Row the item appears in
   * @param class Class the item represents
   * @param lexeme Actual item value
   */
  public MultiLexicalItem(int row, Lexicon type, String lexeme) {
    super(row, type);
    this.lexeme = lexeme;
  }

  @Override
  public String getLexeme() {
    return this.lexeme;
  }

  @Override
  public String toString() {
    return "[class: " + this.getType() + ", row: " + this.getRow() + ", lexeme: " +
        this.getLexeme() + "]";
  }
}

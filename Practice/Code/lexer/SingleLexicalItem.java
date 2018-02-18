package lexer;

/**
 * Represents a univaluated lexical item, this means the item is defined univocally by it's class
 * so there isn't a lexeme.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class SingleLexicalItem extends LexicalItem {
  public UnidadLexicaUnivaluada(int row, int col, ClaseLexica class) {
    super(row,col,class);
  }

  /**
   * This type of item doesn't have a lexeme so this method shouldn't be called.
   *
   * @throws UnsupportedOperationException if called
   */
  @Override
  public String getLexeme() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return "[class: " + this.getClass() + ", row: " + this.getRow() + ", col: " +
        this.getCol() + "]";
  }
}

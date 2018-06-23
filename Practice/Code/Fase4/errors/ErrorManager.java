package errors;

import lexer.LexicalItem;
import java.util.List;

/**
 * Error manager, the different stages can use it to report some errors to the user.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class ErrorManager {
  /**
   * Used for tokenizer errors.
   * Shows a message containing the given row and lexeme, then aborts the execution.
   *
   * @param row Row the error was found on
   * @param lexeme Lexeme found in the given row
   */
  public void lexer(int row, String lexeme) {
    System.out.println("***" + row + " - Unexpected character: " + lexeme);
    System.exit(1);
  }

  /**
   * Used for parsing errors.
   * Shows a message containing the given row, the token found and the expected token list,
   * then aborts the execution.
   *
   * @param item item that caused the error
   */
  public void parser(LexicalItem item) {
    System.out.println("***" + item.getRow() + " - Found: " + item);
    System.exit(1);
  }
}

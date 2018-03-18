package errors;

import lexer.LexicalItem;

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
  public static void lexer(int row, String lexeme) {
    System.out.println("***" + row + " - Unexpected character: " + lexeme);
    System.exit(1);
  }

  /**
   * Used for parsing errors.
   * Shows a message containing the given row, the token found and the expected token list,
   * then aborts the execution.
   *
   * @param row Row the error was found on
   * @param found Token in the given row
   * @param expected List of expected tokens
   */
  public static void parser(int row, LexicalItem found, LexicalItem[] expected) {
    System.out.print("***" + row + " - Found: " + found + " - Expected: ");
    for(LexicalItem i: expected) {
      System.out.print(i + " ");
    }
    System.out.println();
    System.exit(1);
  }

  /**
   * Used for exceptions.
   * Shows both the message and the trace, then aborts the execution.
   *
   * @param e Exception to report
   */
  public static void fatal(Exception e) {
    System.out.println(e);
    e.printStackTrace();
    System.exit(1);
  }
}

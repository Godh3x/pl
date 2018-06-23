package lexer_jlex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Main class to start lexer.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class Main {
  public static void main(String[] arg) throws IOException {
    Reader input = new InputStreamReader(new FileInputStream("../input.txt"));
    TinyLexer lexer = new TinyLexer(input);
    LexicalItem token;
    do {
      token = lexer.yylex();
      System.out.println(token);
    }
    while (token.getType() != Lexicon.EOF);
  }
}
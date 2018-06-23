package parser_javacc;

import java.io.FileReader;

/**
 * Main class to start parser.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class Main {
  /**
   * Instantiates a Eval and call the starting point, the input file is given as an argument.
   * @param args position 0 will be used as input file
   */
  public static void main(String[] args) throws Exception {
    Eval e = new Eval(new FileReader(args[0]));
    System.out.println(e.Sp());
  }
}
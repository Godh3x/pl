package parser;

import java.io.FileReader;

/**
 * Main class to start parser.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class Main {
  /**
   * Instantiates a TinyParser and call the starting point, the input file is given as an argument.
   * @param args position 0 will be used as input file
   */
  public static void main(String[] args) throws Exception {
    TinyParser parser = new TinyParser(new FileReader(args[0]));
    parser.S();
  }
}
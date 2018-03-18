package parser_javacc;

import java.io.FileReader;

public class Main {
  public static void main(String[] args) throws Exception {
    TinyParser parser = new TinyParser(new FileReader(args[0]));
    parser.S();
  }
}
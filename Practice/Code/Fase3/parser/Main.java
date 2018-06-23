package parser;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import lexer.TinyLexer;

/**
 * Main class to start parser.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream("../input.txt"));
		TinyLexer lexer = new TinyLexer(input);
		TinyParser parser = new TinyParser(lexer);
		parser.setScanner(lexer);
		parser.parse();
	}
}


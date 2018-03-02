package lexer_jlex;

import lexer_jlex.Lexicon;

public class LexicalItemFactory {
  private TinyLexer lexer;

  public LexicalItemFactory(TinyLexer lexer) {
    this.lexer = lexer;
  }

  public LexicalItem getItem(String item) throws IllegalArgumentException {
    switch (item) {
      case "LREAL":
          return new MultiLexicalItem(this.lexer.getRow(), Lexicon.LREAL, this.lexer.getLexeme());
      case "ID":
          return new MultiLexicalItem(this.lexer.getRow(), Lexicon.ID, this.lexer.getLexeme());
      case "NUM":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.NUM);
      case "BOOL":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.BOOL);
      case "TRUE":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.TRUE);
      case "FALSE":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.FALSE);
      case "AND":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.AND);
      case "OR":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.OR);
      case "NOT":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.NOT);
      case "PLUS":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.PLUS);
      case "MINUS":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.MINUS);
      case "MUL":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.MUL);
      case "DIV":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.DIV);
      case "IS":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.IS);
      case "EQ":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.EQ);
      case "GT":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.GT);
      case "GEQ":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.GEQ);
      case "LT":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.LT);
      case "LEQ":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.LEQ);
      case "NEQ":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.NEQ);
      case "PCL":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.PCL);
      case "POP":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.POP);
      case "SPROG":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.SPROG);
      case "EOL":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.EOL);
      case "EOF":
          return new SingleLexicalItem(this.lexer.getRow(), Lexicon.EOF);
      default:
          throw new IllegalArgumentException("Invalid item type: " + item);
    }
  }

  public void error() {
    System.err.println("***" + this.lexer.getRow() + " Unexpected character: " +
        this.lexer.getLexeme());
  }
}
package parser;

import lexer_jlex.LexicalItem;
import lexer_jlex.TinyLexer;
import lexer_jlex.Lexicon;
import errors.ErrorManager;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 * Parser implementation, uses a lexer to tokenize the input and parses the result.
 *
 * @author David Antuña Rodríguez
 * @author Javier Carrión García
 */
public class TinyParser {
  private LexicalItem next; // next token to parse
  private TinyLexer lexer; // lexer instance to tokenize
  private ErrorManager err; // error manager instance

  /**
   * Constructor.
   * Instantiates the lexer.
   *
   * @param input Input the lexer will use
   */
  public TinyParser(Reader input) {
    this.err = new ErrorManager();
    this.lexer = new TinyLexer(input);
    this.lexer.setErrorManager(this.err);
    this.nextToken();
  }

  /**
   * Tries to match the next token with the expected one.
   * If they match - call nextToken
   * if they don't  - use the error manager to report
   *
   * @param expected Token to compare next with
   */
  private void pair(Lexicon expected) {
    if (this.next.getType() != expected) {
      this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
        add(expected);
      }});
    }
    this.nextToken();
  }

  /**
   * Use the lexer to get the next token.
   */
  private void nextToken() {
    try {
      this.next = lexer.yylex();
    }
    catch(Exception e) {
      this.err.fatal(e);
    }
  }

  /**
   * Parser starting point.
   * Rules:
   *  S -> Prog EOF
   */
  public void S() {
    switch (this.next.getType()) {
      case NUM:
      case BOOL:
        this.Prog();
        this.pair(Lexicon.EOF);
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.NUM);
          add(Lexicon.BOOL);
        }});
    }
  }

  /**
   * Rules:
   *  Prog -> SDec SPROG Sins
   */
  private void Prog() {
    switch (this.next.getType()) {
      case NUM:
      case BOOL:
        this.SDec();
        this.pair(Lexicon.SPROG);
        this.SIns();
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.NUM);
          add(Lexicon.BOOL);
        }});
    }
  }

  /**
   * Rules:
   *  SDec -> Dec LDec
   */
  private void SDec() {
    switch (next.getType()) {
      case NUM:
      case BOOL:
        this.Dec();
        this.LDec();
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.NUM);
          add(Lexicon.BOOL);
        }});
    }
  }

  /**
   * Rules:
   *  LDec -> EOL Dec LDec
   *  LDec -> .
   */
  private void LDec() {
    switch(this.next.getType()) {
      case EOL:
        this.pair(Lexicon.EOL);
        this.Dec();
        this.LDec();
        break;
      case SPROG:
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.EOL);
          add(Lexicon.SPROG);
        }});
    }
  }

  /**
   * Rules:
   *  SIns -> Ins LIns
   */
  private void SIns() {
    switch (this.next.getType()) {
      case ID:
        this.Ins();
        this.LIns();
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.ID);
        }});
    }
  }

  /**
   * Rules:
   *  LIns -> EOL Ins LIns
   *  LIns -> .
   */
  private void LIns() {
    switch (this.next.getType()) {
      case EOL:
        this.pair(Lexicon.EOL);
        this.Ins();
        this.LIns();
        break;
      case EOF:
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.EOL);
          add(Lexicon.EOF);
        }});
    }
  }

  /**
   * Rules:
   *  Dec -> NUM ID
   *  DEC -> BOOL ID
   */
  private void Dec() {
    switch (this.next.getType()) {
      case NUM:
        this.pair(Lexicon.NUM);
        this.pair(Lexicon.ID);
        break;
      case BOOL:
        this.pair(Lexicon.BOOL);
        this.pair(Lexicon.ID);
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.NUM);
          add(Lexicon.BOOL);
        }});
    }
  }

  /**
   * Rules:
   *  Ins -> ID IS E0
   */
  private void Ins() {
    switch (this.next.getType()) {
      case ID:
        this.pair(Lexicon.ID);
        this.pair(Lexicon.IS);
        this.E0();
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.ID);
        }});
    }
  }

  /**
   * Rules:
   *  E0 -> E1 R0
   */
  private void E0() {
    switch (this.next.getType()) {
      case MINUS:
      case NOT:
      case LREAL:
      case TRUE:
      case FALSE:
      case POP:
        this.E1();
        this.R0();
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.MINUS);
          add(Lexicon.NOT);
          add(Lexicon.LREAL);
          add(Lexicon.TRUE);
          add(Lexicon.FALSE);
          add(Lexicon.POP);
        }});
    }
  }

  /**
   * Rules:
   *  R0 -> Op0 E1 R0
   *  R0 -> .
   */
  private void R0() {
    switch (this.next.getType()) {
      case PLUS:
      case MINUS:
        this.Op0();
        this.E1();
        this.R0();
        break;
      case PCL:
      case EOL:
      case EOF:
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.PLUS);
          add(Lexicon.MINUS);
          add(Lexicon.PCL);
          add(Lexicon.EOL);
          add(Lexicon.EOF);
        }});
    }
  }

  /**
   * Rules:
   *  E1 -> E2 R1
   */
  private void E1() {
    switch (this.next.getType()) {
      case MINUS:
      case NOT:
      case LREAL:
      case TRUE:
      case FALSE:
      case POP:
        this.E2();
        this.R1();
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.MINUS);
          add(Lexicon.NOT);
          add(Lexicon.LREAL);
          add(Lexicon.TRUE);
          add(Lexicon.FALSE);
          add(Lexicon.POP);
        }});
    }
  }

  /**
   * Rules:
   *  R1 -> AND E2 R1
   *  R1 -> OR E2
   *  R1 -> .
   */
  private void R1() {
    switch (this.next.getType()) {
      case AND:
        this.pair(Lexicon.AND);
        this.E2();
        this.R1();
        break;
      case OR:
        this.pair(Lexicon.OR);
        this.E2();
        break;
      case PCL:
      case PLUS:
      case MINUS:
      case EOL:
      case EOF:
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.AND);
          add(Lexicon.OR);
          add(Lexicon.PCL);
          add(Lexicon.PLUS);
          add(Lexicon.MINUS);
          add(Lexicon.EOL);
          add(Lexicon.EOF);
        }});
    }
  }

  /**
   * Rules:
   *  E2 -> E3 R2
   */
  private void E2() {
    switch (next.getType()) {
      case MINUS:
      case NOT:
      case LREAL:
      case TRUE:
      case FALSE:
      case POP:
        this.E3();
        this.R2();
        break;
      default:
        this.err.parser(this.next.getRow(),   next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.MINUS);
          add(Lexicon.NOT);
          add(Lexicon.LREAL);
          add(Lexicon.TRUE);
          add(Lexicon.FALSE);
          add(Lexicon.POP);
        }});
    }
  }

  /**
   * Rules:
   *  R2 -> Op2 E3 R2
   *  R2 -> .
   */
  private void R2() {
    switch (this.next.getType()) {
      case EQ:
      case GT:
      case GEQ:
      case LT:
      case LEQ:
      case NEQ:
        this.Op2();
        this.E3();
        this.R2();
        break;
      case PCL:
      case AND:
      case OR:
      case PLUS:
      case MINUS:
      case EOL:
      case EOF:
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.EQ);
          add(Lexicon.GT);
          add(Lexicon.GEQ);
          add(Lexicon.LT);
          add(Lexicon.LEQ);
          add(Lexicon.NEQ);
          add(Lexicon.PCL);
          add(Lexicon.AND);
          add(Lexicon.OR);
          add(Lexicon.PLUS);
          add(Lexicon.MINUS);
          add(Lexicon.EOL);
          add(Lexicon.EOF);
        }});
    }
  }

  /**
   * Rules:
   *  E3 -> E4 R3
   */
  private void E3() {
    switch (this.next.getType()) {
      case MINUS:
      case NOT:
      case LREAL:
      case TRUE:
      case FALSE:
      case POP:
        this.E4();
        this.R3();
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.MINUS);
          add(Lexicon.NOT);
          add(Lexicon.LREAL);
          add(Lexicon.TRUE);
          add(Lexicon.FALSE);
          add(Lexicon.POP);
        }});
    }
  }

  /**
   * Rules:
   *  R3 -> Op3 E4 R3
   *  R3 -> .
   */
  private void R3() {
    switch (this.next.getType()) {
      case MUL:
      case DIV:
        this.Op3();
        this.E4();
        this.R3();
        break;
      case PCL:
      case EQ:
      case GT:
      case GEQ:
      case LT:
      case LEQ:
      case NEQ:
      case AND:
      case OR:
      case PLUS:
      case MINUS:
      case EOL:
      case EOF:
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.MUL);
          add(Lexicon.DIV);
          add(Lexicon.PCL);
          add(Lexicon.EQ);
          add(Lexicon.GT);
          add(Lexicon.GEQ);
          add(Lexicon.LT);
          add(Lexicon.LEQ);
          add(Lexicon.NEQ);
          add(Lexicon.AND);
          add(Lexicon.OR);
          add(Lexicon.PLUS);
          add(Lexicon.MINUS);
          add(Lexicon.EOL);
          add(Lexicon.EOF);
        }});
    }
  }

  /**
   * Rules:
   *  E4 -> MINUS E4
   *  E4 -> NOT E5
   *  E4 -> E5
   */
  private void E4() {
    switch (this.next.getType()) {
      case MINUS:
        this.pair(Lexicon.MINUS);
        this.E4();
        break;
      case NOT:
        this.pair(Lexicon.NOT);
        this.E5();
        break;
      case LREAL:
      case TRUE:
      case FALSE:
      case POP:
        this.E5();
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.MINUS);
          add(Lexicon.NOT);
          add(Lexicon.LREAL);
          add(Lexicon.TRUE);
          add(Lexicon.FALSE);
          add(Lexicon.POP);
        }});
    }
  }

  /**
   * Rules:
   *  E5 -> LREAL
   *  E5 -> TRUE
   *  E5 -> FALSE
   *  E5 -> POP E0 PCL
   */
  private void E5() {
    switch (this.next.getType()) {
      case LREAL:
        this.pair(Lexicon.LREAL);
        break;
      case TRUE:
        this.pair(Lexicon.TRUE);
        break;
      case FALSE:
        this.pair(Lexicon.FALSE);
        break;
      case POP:
        this.pair(Lexicon.POP);
        this.E0();
        this.pair(Lexicon.PCL);
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.LREAL);
          add(Lexicon.TRUE);
          add(Lexicon.FALSE);
          add(Lexicon.POP);
        }});
    }
  }

  /**
   * Rules:
   *  Op0 -> PLUS
   *  Op0 -> MINUS
   */
  private void Op0() {
    switch (next.getType()) {
      case PLUS:
        this.pair(Lexicon.PLUS);
        break;
      case MINUS:
        this.pair(Lexicon.MINUS);
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.PLUS);
          add(Lexicon.MINUS);
        }});
    }
  }

  /**
   * Rules:
   *  Op2 -> EQ
   *  Op2 -> GT
   *  Op2 -> GEQ
   *  Op2 -> LT
   *  Op2 -> LEQ
   *  Op2 -> NEQ
   */
  private void Op2() {
    switch (this.next.getType()) {
      case EQ:
        this.pair(Lexicon.EQ);
        break;
      case GT:
        this.pair(Lexicon.GT);
        break;
      case GEQ:
        this.pair(Lexicon.GEQ);
        break;
      case LT:
        this.pair(Lexicon.LT);
        break;
      case LEQ:
        this.pair(Lexicon.LEQ);
        break;
      case NEQ:
        this.pair(Lexicon.NEQ);
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.EQ);
          add(Lexicon.GT);
          add(Lexicon.GEQ);
          add(Lexicon.LT);
          add(Lexicon.LEQ);
          add(Lexicon.NEQ);
        }});
    }
  }

  /**
   * Rules:
   *  Op3 -> MUL
   *  Op3 -> DIV
   */
  private void Op3() {
    switch (this.next.getType()) {
      case MUL:
        this.pair(Lexicon.MUL);
        break;
      case DIV:
        this.pair(Lexicon.DIV);
        break;
      default:
        this.err.parser(this.next.getRow(), this.next.getType(), new ArrayList<Lexicon>() {{
          add(Lexicon.MUL);
          add(Lexicon.DIV);
        }});
    }
  }
}

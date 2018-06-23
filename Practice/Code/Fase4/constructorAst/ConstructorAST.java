
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Sat Jun 23 12:09:12 CEST 2018
//----------------------------------------------------

package constructorAst;

import java_cup.runtime.*;
import lexer.TinyLexer;
import lexer.LexicalItem;
import errors.ErrorManager;
import ast.E;
import ast.ASExp;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Sat Jun 23 12:09:12 CEST 2018
  */
public class ConstructorAst extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public ConstructorAst() {super();}

  /** Constructor which sets the default scanner. */
  public ConstructorAst(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ConstructorAst(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\044\000\002\002\003\000\002\002\004\000\002\003" +
    "\005\000\002\004\005\000\002\004\003\000\002\006\005" +
    "\000\002\006\003\000\002\005\004\000\002\005\004\000" +
    "\002\007\005\000\002\010\005\000\002\010\003\000\002" +
    "\011\005\000\002\011\005\000\002\011\003\000\002\012" +
    "\005\000\002\012\003\000\002\013\005\000\002\013\003" +
    "\000\002\014\004\000\002\014\004\000\002\014\003\000" +
    "\002\015\003\000\002\015\003\000\002\015\003\000\002" +
    "\015\005\000\002\016\003\000\002\016\003\000\002\017" +
    "\003\000\002\017\003\000\002\017\003\000\002\017\003" +
    "\000\002\017\003\000\002\017\003\000\002\020\003\000" +
    "\002\020\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\006\006\004\010\010\001\002\000\004\007" +
    "\071\001\002\000\004\002\070\001\002\000\004\002\001" +
    "\001\002\000\006\004\ufffd\005\ufffd\001\002\000\004\007" +
    "\067\001\002\000\006\004\013\005\012\001\002\000\006" +
    "\006\004\010\010\001\002\000\004\007\014\001\002\000" +
    "\004\011\021\001\002\000\006\002\uffff\005\017\001\002" +
    "\000\006\002\ufffb\005\ufffb\001\002\000\004\007\014\001" +
    "\002\000\006\002\ufffc\005\ufffc\001\002\000\016\022\031" +
    "\024\022\027\024\030\025\031\027\032\026\001\002\000" +
    "\016\022\031\024\022\027\024\030\025\031\027\032\026" +
    "\001\002\000\012\002\ufff8\005\ufff8\023\062\024\063\001" +
    "\002\000\040\002\uffeb\005\uffeb\012\uffeb\013\uffeb\014\uffeb" +
    "\015\uffeb\016\uffeb\017\uffeb\020\uffeb\021\uffeb\023\uffeb\024" +
    "\uffeb\025\uffeb\026\uffeb\033\uffeb\001\002\000\040\002\uffea" +
    "\005\uffea\012\uffea\013\uffea\014\uffea\015\uffea\016\uffea\017" +
    "\uffea\020\uffea\021\uffea\023\uffea\024\uffea\025\uffea\026\uffea" +
    "\033\uffea\001\002\000\016\022\031\024\022\027\024\030" +
    "\025\031\027\032\026\001\002\000\040\002\uffe9\005\uffe9" +
    "\012\uffe9\013\uffe9\014\uffe9\015\uffe9\016\uffe9\017\uffe9\020" +
    "\uffe9\021\uffe9\023\uffe9\024\uffe9\025\uffe9\026\uffe9\033\uffe9" +
    "\001\002\000\040\002\uffec\005\uffec\012\uffec\013\uffec\014" +
    "\uffec\015\uffec\016\uffec\017\uffec\020\uffec\021\uffec\023\uffec" +
    "\024\uffec\025\uffec\026\uffec\033\uffec\001\002\000\012\027" +
    "\024\030\025\031\027\032\026\001\002\000\040\002\uffef" +
    "\005\uffef\012\uffef\013\uffef\014\uffef\015\uffef\016\uffef\017" +
    "\uffef\020\uffef\021\uffef\023\uffef\024\uffef\025\uffef\026\uffef" +
    "\033\uffef\001\002\000\040\002\ufff1\005\ufff1\012\044\013" +
    "\045\014\050\015\051\016\052\017\043\020\ufff1\021\ufff1" +
    "\023\ufff1\024\ufff1\025\047\026\046\033\ufff1\001\002\000" +
    "\020\002\ufff3\005\ufff3\020\036\021\037\023\ufff3\024\ufff3" +
    "\033\ufff3\001\002\000\014\002\ufff6\005\ufff6\023\ufff6\024" +
    "\ufff6\033\ufff6\001\002\000\016\022\031\024\022\027\024" +
    "\030\025\031\027\032\026\001\002\000\016\022\031\024" +
    "\022\027\024\030\025\031\027\032\026\001\002\000\014" +
    "\002\ufff4\005\ufff4\023\ufff4\024\ufff4\033\ufff4\001\002\000" +
    "\014\002\ufff5\005\ufff5\023\ufff5\024\ufff5\033\ufff5\001\002" +
    "\000\016\022\031\024\022\027\024\030\025\031\027\032" +
    "\026\001\002\000\016\022\uffe0\024\uffe0\027\uffe0\030\uffe0" +
    "\031\uffe0\032\uffe0\001\002\000\016\022\uffe5\024\uffe5\027" +
    "\uffe5\030\uffe5\031\uffe5\032\uffe5\001\002\000\016\022\uffe4" +
    "\024\uffe4\027\uffe4\030\uffe4\031\uffe4\032\uffe4\001\002\000" +
    "\016\022\uffde\024\uffde\027\uffde\030\uffde\031\uffde\032\uffde" +
    "\001\002\000\016\022\uffdf\024\uffdf\027\uffdf\030\uffdf\031" +
    "\uffdf\032\uffdf\001\002\000\016\022\uffe3\024\uffe3\027\uffe3" +
    "\030\uffe3\031\uffe3\032\uffe3\001\002\000\016\022\uffe2\024" +
    "\uffe2\027\uffe2\030\uffe2\031\uffe2\032\uffe2\001\002\000\016" +
    "\022\uffe1\024\uffe1\027\uffe1\030\uffe1\031\uffe1\032\uffe1\001" +
    "\002\000\016\022\031\024\022\027\024\030\025\031\027" +
    "\032\026\001\002\000\040\002\ufff0\005\ufff0\012\ufff0\013" +
    "\ufff0\014\ufff0\015\ufff0\016\ufff0\017\ufff0\020\ufff0\021\ufff0" +
    "\023\ufff0\024\ufff0\025\ufff0\026\ufff0\033\ufff0\001\002\000" +
    "\024\002\ufff2\005\ufff2\020\ufff2\021\ufff2\023\ufff2\024\ufff2" +
    "\025\047\026\046\033\ufff2\001\002\000\040\002\uffed\005" +
    "\uffed\012\uffed\013\uffed\014\uffed\015\uffed\016\uffed\017\uffed" +
    "\020\uffed\021\uffed\023\uffed\024\uffed\025\uffed\026\uffed\033" +
    "\uffed\001\002\000\010\023\062\024\063\033\060\001\002" +
    "\000\040\002\uffe8\005\uffe8\012\uffe8\013\uffe8\014\uffe8\015" +
    "\uffe8\016\uffe8\017\uffe8\020\uffe8\021\uffe8\023\uffe8\024\uffe8" +
    "\025\uffe8\026\uffe8\033\uffe8\001\002\000\016\022\031\024" +
    "\022\027\024\030\025\031\027\032\026\001\002\000\016" +
    "\022\uffe7\024\uffe7\027\uffe7\030\uffe7\031\uffe7\032\uffe7\001" +
    "\002\000\016\022\uffe6\024\uffe6\027\uffe6\030\uffe6\031\uffe6" +
    "\032\uffe6\001\002\000\014\002\ufff7\005\ufff7\023\ufff7\024" +
    "\ufff7\033\ufff7\001\002\000\040\002\uffee\005\uffee\012\uffee" +
    "\013\uffee\014\uffee\015\uffee\016\uffee\017\uffee\020\uffee\021" +
    "\uffee\023\uffee\024\uffee\025\uffee\026\uffee\033\uffee\001\002" +
    "\000\006\004\ufffe\005\ufffe\001\002\000\006\004\ufff9\005" +
    "\ufff9\001\002\000\004\002\000\001\002\000\006\004\ufffa" +
    "\005\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\012\002\004\003\005\004\010\005\006\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\005\065\001\001\000\006\006\014\007\015\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\007\017\001\001\000\002\001\001\000\016\010\022" +
    "\011\034\012\033\013\032\014\031\015\027\001\001\000" +
    "\006\014\064\015\027\001\001\000\004\016\060\001\001" +
    "\000\002\001\001\000\002\001\001\000\016\010\056\011" +
    "\034\012\033\013\032\014\031\015\027\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\015\055\001\001\000" +
    "\002\001\001\000\006\017\041\020\052\001\001\000\002" +
    "\001\001\000\002\001\001\000\014\011\040\012\033\013" +
    "\032\014\031\015\027\001\001\000\012\012\037\013\032" +
    "\014\031\015\027\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\013\054\014\031\015\027\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\014\053\015\027\001\001\000" +
    "\002\001\001\000\004\020\052\001\001\000\002\001\001" +
    "\000\004\016\060\001\001\000\002\001\001\000\014\011" +
    "\063\012\033\013\032\014\031\015\027\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ConstructorAst$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ConstructorAst$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ConstructorAst$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {

   error = new ErrorManager();
   TinyLexer lexer = (TinyLexer)getScanner();
   lexer.setErrorManager(error);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }


   private ErrorManager error;
   public void syntax_error(Symbol item) {
     error.parser((LexicalItem)item);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$ConstructorAst$actions {


   private ASExp as = new ASExp();

  private final ConstructorAst parser;

  /** Constructor */
  CUP$ConstructorAst$actions(ConstructorAst parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ConstructorAst$do_action_part00000000(
    int                        CUP$ConstructorAst$act_num,
    java_cup.runtime.lr_parser CUP$ConstructorAst$parser,
    java.util.Stack            CUP$ConstructorAst$stack,
    int                        CUP$ConstructorAst$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ConstructorAst$result;

      /* select the action based on the action number */
      switch (CUP$ConstructorAst$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // S ::= Prog 
            {
              Object RESULT =null;
		Object aPROG = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=aPROG 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("S",0, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= S EOF 
            {
              Object RESULT =null;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		RESULT = start_val;
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$ConstructorAst$parser.done_parsing();
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Prog ::= LDec SPROG LIns 
            {
              Object RESULT =null;
		Object aLDEC = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object aLINS = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.prog(aLDEC, aLINS); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Prog",1, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // LDec ::= LDec EOL Dec 
            {
              Object RESULT =null;
		Object aLDEC = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object tDEC = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.ldec(aLDEC, tDEC.ty, tDEC.id); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("LDec",2, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // LDec ::= Dec 
            {
              Object RESULT =null;
		Object tDEC = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.dec(tDEC.ty, tDEC.id); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("LDec",2, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // LIns ::= LIns EOL Ins 
            {
              Object RESULT =null;
		Object aLINS = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object tINS = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.lins(aLINS, tINS.id, tINS.exp); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("LIns",4, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // LIns ::= Ins 
            {
              Object RESULT =null;
		Object tINS = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.ins(tINS.id, tINS.exp) 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("LIns",4, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Dec ::= NUM ID 
            {
              Object RESULT =null;
		Object lexNUM = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object lexID = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=new TDec(); RESULT.ty = lexNUM; RESULT.id = lexID; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Dec",3, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Dec ::= BOOL ID 
            {
              Object RESULT =null;
		Object lexBOOL = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object lexID = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=new TDec(); RESULT.ty = lexBOOL; RESULT.id = lexID; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Dec",3, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Ins ::= ID IS Exp0 
            {
              Object RESULT =null;
		Object lexID = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object aEXP0 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=new TIns(); RESULT.id = lexID; RESULT.exp = aEXP0; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Ins",5, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Exp0 ::= Exp0 Op0 Exp1 
            {
              Object RESULT =null;
		Object aEXP0 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object lexOP0 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object aEXP1 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.mkexpb(lexOP0, aEXP0, aEXP1); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp0",6, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // Exp0 ::= Exp1 
            {
              Object RESULT =null;
		Object aEXP1 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=aEXP1; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp0",6, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // Exp1 ::= Exp2 AND Exp1 
            {
              Object RESULT =null;
		Object aEXP2 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object lexAND = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object aEXP1 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.mkexpb(lexAND, aEXP2, aEXP1); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp1",7, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // Exp1 ::= Exp2 OR Exp2 
            {
              Object RESULT =null;
		Object aEXP20 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object lexOR = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object aEXP21 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.mkexpb(lexOR, aEXP20, aEXP21); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp1",7, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // Exp1 ::= Exp2 
            {
              Object RESULT =null;
		Object aEXP2 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=aEXP2; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp1",7, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // Exp2 ::= Exp3 Op2 Exp3 
            {
              Object RESULT =null;
		Object aEXP30 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object lexOP2 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object aEXP31 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.mkexpb(lexOP2, aEXP30, aEXP31); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp2",8, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // Exp2 ::= Exp3 
            {
              Object RESULT =null;
		Object aEXP3 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=aEXP3; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp2",8, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // Exp3 ::= Exp3 Op3 Exp4 
            {
              Object RESULT =null;
		Object aEXP3 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-2)).value;
		Object lexOP3 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object aEXP4 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.mkexpb(lexOP3, aEXP3, aEXP4); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp3",9, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // Exp3 ::= Exp4 
            {
              Object RESULT =null;
		Object aEXP4 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=aEXP4; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp3",9, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // Exp4 ::= MINUS Exp4 
            {
              Object RESULT =null;
		Object lexMINUS = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object aEXP4 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.mkexpu(lexMINUS, aEXP4); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp4",10, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // Exp4 ::= NOT Exp5 
            {
              Object RESULT =null;
		Object lexNOT = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		Object aEXP5 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.mkexpu(lexNOT, aEXP5); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp4",10, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // Exp4 ::= Exp5 
            {
              Object RESULT =null;
		Object aEXP5 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=aEXP5; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp4",10, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // Exp5 ::= LREAL 
            {
              Object RESULT =null;
		Object lexLREAL = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.num(lexLREAL); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp5",11, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // Exp5 ::= TRUE 
            {
              Object RESULT =null;
		Object lexTRUE = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.true(lexTRUE); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp5",11, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // Exp5 ::= FALSE 
            {
              Object RESULT =null;
		Object lexFALSE = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=as.false(lexFALSE); 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp5",11, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // Exp5 ::= POP Exp0 PCL 
            {
              Object RESULT =null;
		Object aEXP0 = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.elementAt(CUP$ConstructorAst$top-1)).value;
		 RESULT=aEXP0; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Exp5",11, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // Op0 ::= PLUS 
            {
              Object RESULT =null;
		Object lexPLUS = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexPlus; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op0",12, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // Op0 ::= MINUS 
            {
              Object RESULT =null;
		Object lexMINUS = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexPlus; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op0",12, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // Op2 ::= EQ 
            {
              Object RESULT =null;
		Object lexEQ = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexEQ; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op2",13, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // Op2 ::= GT 
            {
              Object RESULT =null;
		Object lexGT = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexGT; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op2",13, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // Op2 ::= GEQ 
            {
              Object RESULT =null;
		Object lexGEQ = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexGEQ; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op2",13, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // Op2 ::= LT 
            {
              Object RESULT =null;
		Object lexLT = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexLT; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op2",13, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // Op2 ::= LEQ 
            {
              Object RESULT =null;
		Object lexLEQ = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexLEQ; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op2",13, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // Op2 ::= NEQ 
            {
              Object RESULT =null;
		Object lexNEQ = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexNEQ; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op2",13, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // Op3 ::= MUL 
            {
              Object RESULT =null;
		Object lexMUL = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexMUL; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op3",14, RESULT);
            }
          return CUP$ConstructorAst$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // Op3 ::= DIV 
            {
              Object RESULT =null;
		Object lexDIV = (Object)((java_cup.runtime.Symbol) CUP$ConstructorAst$stack.peek()).value;
		 RESULT=lexDIV; 
              CUP$ConstructorAst$result = parser.getSymbolFactory().newSymbol("Op3",14, RESULT);
            }
          return CUP$ConstructorAst$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ConstructorAst$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ConstructorAst$do_action(
    int                        CUP$ConstructorAst$act_num,
    java_cup.runtime.lr_parser CUP$ConstructorAst$parser,
    java.util.Stack            CUP$ConstructorAst$stack,
    int                        CUP$ConstructorAst$top)
    throws java.lang.Exception
    {
              return CUP$ConstructorAst$do_action_part00000000(
                               CUP$ConstructorAst$act_num,
                               CUP$ConstructorAst$parser,
                               CUP$ConstructorAst$stack,
                               CUP$ConstructorAst$top);
    }
}


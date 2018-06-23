package ast;

public class ASExp {
  public E plus(E opnd1, E opnd2) {return new Plus(opnd1,opnd2);}
  public E minus(E opnd1, E opnd2) {return new Minus(opnd1,opnd2);}
  public E mul(E opnd1, E opnd2) {return new Mul(opnd1,opnd2);}
  public E div(E opnd1, E opnd2) {return new Div(opnd1,opnd2);}
  public E eq(E opnd1, E opnd2) {return new Eq(opnd1,opnd2);}
  public E gt(E opnd1, E opnd2) {return new Gt(opnd1,opnd2);}
  public E geq(E opnd1, E opnd2) {return new Geq(opnd1,opnd2);}
  public E lt(E opnd1, E opnd2) {return new Lt(opnd1,opnd2);}
  public E leq(E opnd1, E opnd2) {return new Leq(opnd1,opnd2);}
  public E and(E opnd1, E opnd2) {return new And(opnd1,opnd2);}
  public E or(E opnd1, E opnd2) {return new Or(opnd1,opnd2);}
  public E neq(E opnd1, E opnd2) {return new Neq(opnd1,opnd2);}
  public E sign(E opnd1) {return new Sign(opnd1);}
  public E not(E opnd1) {return new Not(opnd1);}
  public E num(String n) {return new Num(n);}
  public E true_f() {return new True();}
  public E false_f() {return new False();}
  public LIs lins(LIs list, String id, E exp) {
    return new LIns(list, id, exp);
  }
  public LIs ins(String id, E exp) {return new Ins(id, exp);}
  public LDs ldec(LDs list, String ty, String id) {
    return new LDec(list, ty, id);
  }
  public LDs dec(String ty, String id) {
    return new Dec(ty, id);
  }
  public Prog prog(LDs listd,LIs listi) {return new Prog(listd, listi);}
}
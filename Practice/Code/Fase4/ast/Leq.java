package ast;

public class Leq extends EBin {
  public Leq(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.LEQ;
  }

  public String toString() {
    return "leq{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

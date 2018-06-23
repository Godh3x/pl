package ast;

public class Gt extends EBin {
  public Gt(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.GT;
  }

  public String toString() {
    return "gt{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

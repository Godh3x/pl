package ast;

public class Neq extends EBin {
  public Neq(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.NEQ;
  }

  public String toString() {
    return "neq{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

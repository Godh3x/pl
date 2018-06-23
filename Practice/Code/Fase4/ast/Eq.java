package ast;

public class Eq extends EBin {
  public Eq(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.EQ;
  }

  public String toString() {
    return "eq{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

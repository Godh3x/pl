package ast;

public class Lte extends EBin {
  public Lte(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.LTE;
  }

  public String toString() {
    return "lte{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

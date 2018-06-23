package ast;

public class Geq extends EBin {
  public Geq(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.GEQ;
  }

  public String toString() {
    return "geq{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

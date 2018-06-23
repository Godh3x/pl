package ast;

public class Gte extends EBin {
  public Gte(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.GTE;
  }

  public String toString() {
    return "gte{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

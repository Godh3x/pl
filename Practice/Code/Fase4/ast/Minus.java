package ast;

public class Minus extends EBin {
  public Minus(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.MINUS;
  }

  public String toString() {
    return "minus{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

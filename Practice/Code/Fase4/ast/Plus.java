package ast;

public class Plus extends EBin {
  public Plus(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.PLUS;
  }

  public String toString() {
    return "plus{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

package ast;

public class Lt extends EBin {
  public Lt(E opnd1, E opnd2) {
    super(opnd1,opnd2);
  }

  public TypeE type() {
    return TypeE.LT;
  }

  public String toString() {
    return "lt{"+opnd1().toString()+","+opnd2().toString()+"}";
  }
}

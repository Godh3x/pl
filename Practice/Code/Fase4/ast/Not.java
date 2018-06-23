package ast;

public class Not extends EUn {
  public Not(E opnd1) {
    super(opnd1);
  }

  public TypeE type() {
    return TypeE.NOT;
  }

  public String toString() {
    return "not{"+opnd1().toString()+"}";
  }
}

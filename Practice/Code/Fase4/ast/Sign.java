package ast;

public class Sign extends EUn {
  public Sign(E opnd1) {
    super(opnd1);
  }

  public TypeE type() {
    return TypeE.SIGN;
  }

  public String toString() {
    return "sign{"+opnd1().toString()+"}";
  }
}

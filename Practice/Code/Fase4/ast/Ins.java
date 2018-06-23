package ast;

public class Ins extends E {
  private String id;
  private E exp;

  public Ins(String id, E exp) {
    this.id = id;
    this.exp = exp;
  }

  public String id() { return this.id; }
  public E exp() { return this.exp; }
  public TypeE type() { return TypeE.INS; }
  public String toString() {
    return "ins{"+id().toString()+","+exp().toString()+"}";
  }
}

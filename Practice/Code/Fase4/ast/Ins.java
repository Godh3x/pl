package ast;

public class Ins extends LIs {
  private String id;
  private E exp;
  public Ins(String id, E exp) {
    this.id = id;
    this.exp = exp;
  }

  public String id() {return id;}
  public E exp() {return exp;}
  public TypeE type() {return TypeE.INS;}
  public String toString() {
    return id().toString()+" = "+exp().toString();
  }
}


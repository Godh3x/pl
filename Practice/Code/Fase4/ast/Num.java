package ast;

public class Num extends E {
  private String v;

  public Num(String v) {
    this.v = v;
  }

  public String num() { return this.v; }
  public TypeE type() { return TypeE.NUM; }
  public String toString() { return this.v; }
}

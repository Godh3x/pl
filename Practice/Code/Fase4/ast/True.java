package ast;

public class True extends E {
  private String v;

  public True(String v) {
    this.v = v;
  }

  public String num() { return this.v; }
  public TypeE type() { return TypeE.TRUE; }
  public String toString() { return this.v; }
}

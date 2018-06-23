package ast;

public class ID extends E {
  private String v;

  public ID(String v) {
    this.v = v;
  }

  public String id() { return this.v; }
  public TypeE type() { return TypeE.ID; }
  public String toString() { return this.v; }
}

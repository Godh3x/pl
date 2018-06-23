package ast;

public class False extends E {
  private String v;

  public False() {
    this.v = "false";
  }

  public String num() { return this.v; }
  public TypeE type() { return TypeE.FALSE; }
  public String toString() { return this.v; }
}

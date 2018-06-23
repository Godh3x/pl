package ast;

public class Dec extends LDs {
  private String ty;
  private String id;

  public Dec(String ty, String id) {
    this.ty = ty;
    this.id = id;
  }

  public String ty() {return ty;}
  public String id() {return id;}
  public TypeE type() {return TypeE.DEC;}
  public String toString() {
    return ty().toString() + " " + id().toString();
  }
}

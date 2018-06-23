package ast;

public class Dec extends E {
  private String ty;
  private String id;

  public Dec(String ty, String id) {
    this.ty = ty;
    this.id = id;
  }

  public String id() { return this.id; }
  public String ty() { return this.ty; }
  public TypeE type() { return TypeE.DEC; }
  public String toString() {
    return "dec{"+id().toString()+","+ty().toString()+"}";
  }
}

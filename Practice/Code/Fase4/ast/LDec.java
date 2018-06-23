package ast;

public class LDec {
  private LDec list;
  private String ty;
  private String id;

  public LDec(String ty, String id) {
    this.ty = ty;
    this.id = id;
  }
  public LDec(LDec list, String ty, String id) {
    this(ty, id);
    this.list = list;
  }

  public String list() { return this.list; }
  public String id() { return this.id; }
  public String ty() { return this.ty; }
  public TypeE type() { return TypeE.DEC; }
  public String toString() {
    if (this.list) {
      return "ldec{"+list().toString+","+id().toString()+","+ty().toString()+"}";
    }
    else {
      return "ldec{"+id().toString()+","+ty().toString()+"}";
    }
  }
}

package ast;

public class LIns {
  private LIns list;
  private String ty;
  private E exp;

  public LIns(String id, E exp) {
    this.id = id;
    this.exp = exp;
  }
  public LIns(LIns list, String id, E exp) {
    this(id, exp);
    this.list = list;
  }

  public String list() { return this.list; }
  public String id() { return this.id; }
  public String exp() { return this.exp; }
  public TypeE type() { return TypeE.LINS; }
  public String toString() {
    if (this.list) {
      return "lins{"+list().toString()+","+id().toString()+","+exp().toString()+"}";
    }
    else {
      return "lins{"+id().toString()+","+exp().toString()+"}";
    }
  }
}

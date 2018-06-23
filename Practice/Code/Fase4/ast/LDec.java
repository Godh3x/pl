package ast;

public class LDec extends LDs {
  private String ty;
  private String id;
  private LDs list;
  public LDec(LDs list, String ty, String id) {
    this.list = list;
    this.ty = ty;
    this.id = id;
  }

  public LDs lds() {return this.list;}
  public String ty() {return this.ty;}
  public String id() {return this.id;}
  public TypeE type() {return TypeE.LDEC;}
  public String toString() {
    return "ldec{"+lds().toString() + " ; " + ty().toString() + " " + id().toString()+"}";
  }
}

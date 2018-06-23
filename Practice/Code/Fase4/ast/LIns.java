package ast;

public class LIns extends LIs {
  private String id;
  private E exp;
  private LIs list;
  public LIns(LIs list,String id, E exp) {
    this.list = list;
    this.id = id;
    this.exp = exp;
  }

  public LIs lis() {return list;}
  public String id() {return id;}
  public E exp() {return exp;}
  public TypeE type() {return TypeE.LINS;}
  public String toString() {
    return "lins{"+lis().toString() + " ; " + id().toString() + " = " + exp().toString()+"}";
  }
}
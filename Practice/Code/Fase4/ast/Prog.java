package ast;

public class Prog {
  private LDec ldec;
  private LIns lins;

  public Prog(LDec ldec, LIns lins) {
    this.ldec = ldec;
    this.lins = lins;
  }

  public String ldec() { return this.ldec; }
  public String id() { return this.lins; }
  public TypeE type() { return TypeE.PROG; }
  public String toString() {
    return "prog{"+ldec().toString()+","+lins().toString()+"}";
  }
}

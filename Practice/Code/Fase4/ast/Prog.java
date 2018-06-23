package ast;

public class Prog {
  private LDs ldec;
  private LIs lins;

  public Prog(LDs ldec, LIs lins) {
    this.ldec = ldec;
    this.lins = lins;
  }

  public LDs ldec() { return this.ldec; }
  public LIs lins() { return this.lins; }
  public TypeE type() { return TypeE.PROG; }
  public String toString() {
    return "prog{"+ldec().toString()+", "+lins().toString()+"}";
  }
}

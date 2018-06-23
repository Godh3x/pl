package ast;

public abstract class LDs {
  public abstract TypeE type();
  public LDs lds() {throw new UnsupportedOperationException("lds");}
  public String ty() {throw new UnsupportedOperationException("ty");}
  public String id() {throw new UnsupportedOperationException("id");}
}
package ast;

public abstract class LIs {
  public abstract TypeE type();
  public LIs lis() {throw new UnsupportedOperationException("lis");}
  public String id() {throw new UnsupportedOperationException("id");}
  public E exp() {throw new UnsupportedOperationException("exp");}
}
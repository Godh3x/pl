package javacc;

import ast.E;

public class TLIs {
  public String id;
  public E exp;

  public TLIs(String id, E exp) {
    this.id = id;
    this.exp = exp;
  }
}
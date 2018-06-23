package ast;

public class ASExp {
  /* Binary Ops */
  public E mkexpb(String op, E opnd1, E opnd2) {
    switch(op) {
      case '+':
        return new Plus(opnd1,opnd2);
      case '-':
        return new Minus(opnd1,opnd2);
      case '*':
        return new Mul(opnd1,opnd2);
      case '/':
        return new Div(opnd1,opnd2);
      case 'and':
        return new And(opnd1,opnd2);
      case 'or':
        return new Or(opnd1,opnd2);
      case '==':
        return new Eq(opnd1,opnd2);
      case '>':
        return new Gt(opnd1,opnd2);
      case '>=':
        return new Gte(opnd1,opnd2);
      case '<':
        return new Lt(opnd1,opnd2);
      case '<=':
        return new Lte(opnd1,opnd2);
      case '!=':
        return new Neq(opnd1,opnd2);
      default:
        throw new IllegalArgumentException("Invalid binary operation: " + op);
    }
  }
  /* Unary Ops */
  public E mkexpu(String op, E opnd) {
    switch (op) {
      case '-':
        return new Sign(opnd1);
      case 'not':
        return new Not(opnd1);
      default:
        throw new IllegalArgumentException("Invalid unary operation: " + op);
    }
  }
  /* Basic */
  public E num(String num) {return new Num(num);}
  public E true(String b) {return new True(b);}
  public E false(String b) {return new False(b);}
}

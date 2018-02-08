package cz.dusanrychnovsky.booleanexpressions;

public class And implements Expression {

  private final Expression left;
  private final Expression right;

  public And(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  public boolean evaluate() {
    return left.evaluate() && right.evaluate();
  }
}

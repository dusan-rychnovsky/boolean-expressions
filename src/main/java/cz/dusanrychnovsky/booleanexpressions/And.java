package cz.dusanrychnovsky.booleanexpressions;

public class And implements Expression {

  private final Expression left;
  private final Expression right;

  public And(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean evaluate() {
    return left.evaluate() && right.evaluate();
  }

  @Override
  public int hashCode() {
    return left.hashCode() + right.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof And)) {
      return false;
    }
    And other = (And) obj;
    return
      left.equals(other.left) &&
      right.equals(other.right);
  }
}

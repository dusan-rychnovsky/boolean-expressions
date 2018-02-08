package cz.dusanrychnovsky.booleanexpressions;

public class Eq<T> implements Expression {

  private final Const<T> left;
  private final Const<T> right;

  public Eq(Const<T> left, Const<T> right) {
    this.left = left;
    this.right = right;
  }

  public Eq(T left, T right) {
    this(new Const<>(left), new Const<>(right));
  }

  public boolean evaluate() {
    return left.getValue().equals(right.getValue());
  }
}

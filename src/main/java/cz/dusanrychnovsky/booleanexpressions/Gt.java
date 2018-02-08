package cz.dusanrychnovsky.booleanexpressions;

public class Gt<T extends Comparable<T>> implements Expression {

  private final Const<T> left;
  private final Const<T> right;

  public Gt(Const<T> left, Const<T> right) {
    this.left = left;
    this.right = right;
  }

  public Gt(T left, T right) {
    this(new Const<>(left), new Const<>(right));
  }
  public boolean evaluate() {
    return left.getValue().compareTo(right.getValue()) > 0;
  }
}

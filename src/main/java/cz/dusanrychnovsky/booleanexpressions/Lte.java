package cz.dusanrychnovsky.booleanexpressions;

public class Lte<T extends Comparable<T>> implements Expression {

  private final Value<T> left;
  private final Value<T> right;

  public Lte(Value<T> left, Value<T> right) {
    this.left = left;
    this.right = right;
  }

  public Lte(T left, T right) {
    this(new Const<>(left), new Const<>(right));
  }

  @Override
  public boolean evaluate() {
    return left.getValue().compareTo(right.getValue()) <= 0;
  }
}

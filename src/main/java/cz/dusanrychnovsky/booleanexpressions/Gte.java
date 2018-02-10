package cz.dusanrychnovsky.booleanexpressions;

public class Gte<T extends Comparable<T>> implements Expression {

  private final Value<T> left;
  private final Value<T> right;

  public Gte(Value<T> left, Value<T> right) {
    this.left = left;
    this.right = right;
  }

  public Gte(T left, T right) {
    this(new Const<>(left), new Const<>(right));
  }

  @Override
  public boolean evaluate() {
    return left.getValue().compareTo(right.getValue()) >= 0;
  }
}

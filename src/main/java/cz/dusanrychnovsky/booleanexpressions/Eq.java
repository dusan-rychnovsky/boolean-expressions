package cz.dusanrychnovsky.booleanexpressions;

public class Eq<T> implements Expression {

  private final Value<T> left;
  private final Value<T> right;

  public Eq(Value<T> left, Value<T> right) {
    this.left = left;
    this.right = right;
  }

  public Eq(T left, T right) {
    this(new Const<>(left), new Const<>(right));
  }

  @Override
  public boolean evaluate() {
    return left.getValue().equals(right.getValue());
  }
}

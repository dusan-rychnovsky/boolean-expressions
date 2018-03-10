package cz.dusanrychnovsky.booleanexpressions;

@lombok.Value
public class Gt<T extends Comparable<T>> implements Expression {

  Value<T> left;
  Value<T> right;

  public Gt(Value<T> left, Value<T> right) {
    this.left = left;
    this.right = right;
  }

  public Gt(T left, T right) {
    this(new Const<>(left), new Const<>(right));
  }

  @Override
  public boolean evaluate() {
    return left.getValue().compareTo(right.getValue()) > 0;
  }
}

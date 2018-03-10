package cz.dusanrychnovsky.booleanexpressions;

@lombok.Value
public class Lte<T extends Comparable<T>> implements Expression {

  Value<T> left;
  Value<T> right;

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

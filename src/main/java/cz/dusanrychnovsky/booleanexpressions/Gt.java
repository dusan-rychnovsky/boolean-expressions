package cz.dusanrychnovsky.booleanexpressions;

public class Gt<T extends Comparable<T>> implements Expression {

  private final Value<T> left;
  private final Value<T> right;

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

  @Override
  public int hashCode() {
    return left.hashCode() + right.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Gt)) {
      return false;
    }
    Gt<T> other = (Gt<T>) obj;
    return
      left.equals(other.left) &&
      right.equals(other.right);
  }
}

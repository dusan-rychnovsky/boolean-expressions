package cz.dusanrychnovsky.booleanexpressions;

public class Lt<T extends Comparable<T>> implements Expression {

  private final Value<T> left;
  private final Value<T> right;

  public Lt(Value<T> left, Value<T> right) {
    this.left = left;
    this.right = right;
  }

  public Lt(T left, T right) {
    this(new Const<>(left), new Const<>(right));
  }

  @Override
  public boolean evaluate() {
    return left.getValue().compareTo(right.getValue()) < 0;
  }

  @Override
  public int hashCode() {
    return left.hashCode() + right.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Lt)) {
      return false;
    }
    Lt<T> other = (Lt<T>) obj;
    return
      left.equals(other.left) &&
        right.equals(other.right);
  }
}

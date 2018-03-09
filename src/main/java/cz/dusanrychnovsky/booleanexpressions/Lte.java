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

  @Override
  public int hashCode() {
    return left.hashCode() + right.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Lte)) {
      return false;
    }
    Lte<T> other = (Lte<T>) obj;
    return
      left.equals(other.left) &&
      right.equals(other.right);
  }
}

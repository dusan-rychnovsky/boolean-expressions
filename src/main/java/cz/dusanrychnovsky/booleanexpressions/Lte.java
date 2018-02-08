package cz.dusanrychnovsky.booleanexpressions;

public class Lte<T extends Comparable<T>> implements Expression {

  private final Const<T> left;
  private final Const<T> right;

  public Lte(Const<T> left, Const<T> right) {
    this.left = left;
    this.right = right;
  }

  public boolean evaluate() {
    return left.getValue().compareTo(right.getValue()) <= 0;
  }
}

package cz.dusanrychnovsky.booleanexpressions;

public class Const<T> {

  private final T value;

  public Const(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }
}

package cz.dusanrychnovsky.booleanexpressions;

public class Const<T> implements Value<T> {

  private final T value;

  public Const(T value) {
    this.value = value;
  }

  @Override
  public T getValue() {
    return this.value;
  }
}

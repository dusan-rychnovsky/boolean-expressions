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

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Const)) {
      return false;
    }
    Const<T> other = (Const<T>) obj;
    return value.equals(other.value);
  }
}

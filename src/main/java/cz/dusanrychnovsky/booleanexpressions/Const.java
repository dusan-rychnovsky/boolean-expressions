package cz.dusanrychnovsky.booleanexpressions;

@lombok.Value
public class Const<T> implements Value<T> {

  T value;

  @Override
  public T getValue() {
    return this.value;
  }
}

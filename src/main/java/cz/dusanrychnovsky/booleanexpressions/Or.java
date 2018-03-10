package cz.dusanrychnovsky.booleanexpressions;

import lombok.Value;

@Value
public class Or implements Expression {

  Expression left;
  Expression right;

  @Override
  public boolean evaluate() {
    return left.evaluate() || right.evaluate();
  }
}

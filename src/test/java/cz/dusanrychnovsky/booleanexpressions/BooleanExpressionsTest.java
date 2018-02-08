package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanExpressionsTest {

  @Test
  public void canEvaluateSimpleExpression()
  {
    assertTrue(
      new And(
        new Or(
          new Eq<>(new Const<>("ahoj"), new Const<>("hello")),
          new Lte<>(new Const<>(5), new Const<>(5))
        ),
        new Gt<>(new Const<>(3), new Const<>(1))
      ).evaluate()
    );
  }
}

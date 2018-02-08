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
          new Eq<>("ahoj", "hello"),
          new Lte<>(5, 5)
        ),
        new Gt<>(3, 1)
      ).evaluate()
    );
  }
}

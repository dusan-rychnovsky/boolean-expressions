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
          new Eq<String>(new Const<String>("ahoj"), new Const<String>("hello")),
          new Lte<Integer>(new Const<Integer>(5), new Const<Integer>(5))
        ),
        new Gt<Integer>(new Const<Integer>(3), new Const<Integer>(1))
      ).evaluate()
    );
  }
}

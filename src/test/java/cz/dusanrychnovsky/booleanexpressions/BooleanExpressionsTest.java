package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BooleanExpressionsTest {

  private ExpressionParser parser = new ExpressionParser();

  @Test
  public void expressions() {
    assertTrue(evaluate("(3 < 5) AND ((1 = 2) OR (5 = 5))"));
    assertTrue(evaluate("DAYDIFF(2018-01-01, 2018-01-05) = 4 AND ADDDAYS(2018-01-01, 4) = DATE(2018-01-05)"));
    assertTrue(evaluate("5 < 1 OR (5 = 1 OR 5 > 1)"));
  }

  private boolean evaluate(String expr) {
    try {
      return parser.parse(expr).evaluate();
    }
    catch (ParseException ex) {
      throw new AssertionError(ex);
    }
  }
}

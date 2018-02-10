package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LteTest {

  @Test
  public void lessThanOrEqual() {
    assertTrue(new Lte<>(1, 2).evaluate());
    assertTrue(new Lte<>(2, 2).evaluate());
    assertFalse(new Lte<>(2, 1).evaluate());
  }
}

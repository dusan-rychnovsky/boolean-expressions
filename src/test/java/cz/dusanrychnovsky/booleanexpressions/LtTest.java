package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LtTest {

  @Test
  public void lessThan() {
    assertTrue(new Lt<>(1, 2).evaluate());
    assertFalse(new Lt<>(2, 2).evaluate());
    assertFalse(new Lt<>(2, 1).evaluate());
  }
}

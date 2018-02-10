package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GtTest {

  @Test
  public void greaterThan() {
    assertFalse(new Gt<>(1, 2).evaluate());
    assertFalse(new Gt<>(2, 2).evaluate());
    assertTrue(new Gt<>(2, 1).evaluate());
  }
}

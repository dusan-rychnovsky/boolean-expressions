package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GteTest {

  @Test
  public void greaterThanOrEqual() {
    assertFalse(new Gte<>(1, 2).evaluate());
    assertTrue(new Gte<>(2, 2).evaluate());
    assertTrue(new Gte<>(2, 1).evaluate());
  }
}

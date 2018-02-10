package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqTest {

  @Test
  public void equal() {
    assertFalse(new Eq<>(1, 2).evaluate());
    assertTrue(new Eq<>(2, 2).evaluate());
    assertFalse(new Eq<>(2, 1).evaluate());
  }
}

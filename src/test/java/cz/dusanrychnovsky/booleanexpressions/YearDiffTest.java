package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YearDiffTest {

  @Test
  public void exactSameDate() {
    assertEquals(
      0,
      new YearDiff(
        new LocalDate(2018, 5, 7),
        new LocalDate(2018, 5, 7)
      ).getValue().intValue()
    );
  }

  @Test
  public void sameYear() {
    assertEquals(
      0,
      new YearDiff(
        new LocalDate(2018, 3, 7),
        new LocalDate(2018, 5, 21)
      ).getValue().intValue()
    );
  }

  @Test
  public void differentYear() {
    assertEquals(
      3,
      new YearDiff(
        new LocalDate(2015, 3, 7),
        new LocalDate(2018, 5, 21)
      ).getValue().intValue()
    );
  }

  @Test
  public void negativeDifference() {
    assertEquals(
      -3,
      new YearDiff(
        new LocalDate(2018, 5, 21),
        new LocalDate(2015, 3, 7)
      ).getValue().intValue()
    );
  }
}

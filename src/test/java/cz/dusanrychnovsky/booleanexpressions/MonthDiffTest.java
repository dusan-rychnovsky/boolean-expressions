package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonthDiffTest {

  @Test
  public void exactSameDate() {
    assertEquals(
      0,
      new MonthDiff(
        new LocalDate(2018, 5, 7),
        new LocalDate(2018, 5, 7)
      ).getValue().intValue()
    );
  }

  @Test
  public void sameMonth() {
    assertEquals(
      0,
      new MonthDiff(
        new LocalDate(2018, 5, 7),
        new LocalDate(2018, 5, 21)
      ).getValue().intValue()
    );
  }

  @Test
  public void sameYear() {
    assertEquals(
      2,
      new MonthDiff(
        new LocalDate(2018, 3, 7),
        new LocalDate(2018, 5, 21)
      ).getValue().intValue()
    );
  }

  @Test
  public void differentYear() {
    assertEquals(
      38,
      new MonthDiff(
        new LocalDate(2015, 3, 7),
        new LocalDate(2018, 5, 21)
      ).getValue().intValue()
    );
  }

  @Test
  public void negativeDifference() {
    assertEquals(
      -38,
      new MonthDiff(
        new LocalDate(2018, 5, 21),
        new LocalDate(2015, 3, 7)
      ).getValue().intValue()
    );
  }
}

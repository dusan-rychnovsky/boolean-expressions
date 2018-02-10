package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddDaysTest {

  @Test
  public void addZero_returnsSameDate() {
    assertEquals(
      new LocalDate(2017, 5, 20),
      new AddDays(
        new LocalDate(2017, 5, 20),
        0
      ).getValue()
    );
  }

  @Test
  public void withinSameMonth() {
    assertEquals(
      new LocalDate(2017, 5, 25),
      new AddDays(
        new LocalDate(2017, 5, 20),
        5
      ).getValue()
    );
  }

  @Test
  public void acrossMonths() {
    assertEquals(
      new LocalDate(2017, 8, 28),
      new AddDays(
        new LocalDate(2017, 5, 20),
        100
      ).getValue()
    );
  }

  @Test
  public void acrossYears() {
    assertEquals(
      new LocalDate(2020, 2, 14),
      new AddDays(
        new LocalDate(2017, 5, 20),
        1000
      ).getValue()
    );
  }

  @Test
  public void negativeDays() {
    assertEquals(
      new LocalDate(2014, 8, 24),
      new AddDays(
        new LocalDate(2017, 5, 20),
        -1000
      ).getValue()
    );
  }
}

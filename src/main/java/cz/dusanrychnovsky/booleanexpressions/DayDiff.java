package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Period;

public class DayDiff implements Value<Integer> {

  private final LocalDate left;
  private final LocalDate right;

  public DayDiff(LocalDate left, LocalDate right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Integer getValue() {
    return Days.daysBetween(left, right).getDays();
  }
}

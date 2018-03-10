package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.Days;
import org.joda.time.LocalDate;

@lombok.Value
public class DayDiff implements Value<Integer> {

  LocalDate left;
  LocalDate right;

  @Override
  public Integer getValue() {
    return Days.daysBetween(left, right).getDays();
  }
}

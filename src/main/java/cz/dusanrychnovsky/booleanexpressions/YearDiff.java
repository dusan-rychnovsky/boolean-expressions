package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.joda.time.Years;

@lombok.Value
public class YearDiff implements Value<Integer> {

  LocalDate left;
  LocalDate right;

  @Override
  public Integer getValue() {
    return Years.yearsBetween(left, right).getYears();
  }
}

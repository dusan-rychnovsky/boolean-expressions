package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.joda.time.Months;

@lombok.Value
public class MonthDiff implements Value<Integer> {

  LocalDate left;
  LocalDate right;

  @Override
  public Integer getValue() {
    return Months.monthsBetween(left, right).getMonths();
  }
}

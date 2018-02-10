package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class YearDiff implements Value<Integer> {

  private final LocalDate left;
  private final LocalDate right;

  public YearDiff(LocalDate left, LocalDate right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Integer getValue() {
    return Years.yearsBetween(left, right).getYears();
  }
}

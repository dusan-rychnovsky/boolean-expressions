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

  @Override
  public int hashCode() {
    return left.hashCode() + right.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof YearDiff)) {
      return false;
    }
    YearDiff other = (YearDiff) obj;
    return
      left.equals(other.left) &&
      right.equals(other.right);
  }
}

package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.Days;
import org.joda.time.LocalDate;

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

  @Override
  public int hashCode() {
    return left.hashCode() + right.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof DayDiff)) {
      return false;
    }
    DayDiff other = (DayDiff) obj;
    return
      left.equals(other.left) &&
      right.equals(other.right);
  }
}

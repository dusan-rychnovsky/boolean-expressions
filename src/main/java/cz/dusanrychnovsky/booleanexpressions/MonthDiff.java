package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.joda.time.Months;

public class MonthDiff implements Value<Integer> {

  private final LocalDate left;
  private final LocalDate right;

  public MonthDiff(LocalDate left, LocalDate right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Integer getValue() {
    return Months.monthsBetween(left, right).getMonths();
  }

  @Override
  public int hashCode() {
    return left.hashCode() + right.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof MonthDiff)) {
      return false;
    }
    MonthDiff other = (MonthDiff) obj;
    return
      left.equals(other.left) &&
      right.equals(other.right);
  }
}

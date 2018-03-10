package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;

public class AddDays implements Value<LocalDate> {

  private final LocalDate date;
  private final int days;

  public AddDays(LocalDate date, int days) {
    this.date = date;
    this.days = days;
  }

  @Override
  public LocalDate getValue() {
    return date.plusDays(days);
  }

  @Override
  public int hashCode() {
    return date.hashCode() + days;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AddDays)) {
      return false;
    }
    AddDays other = (AddDays) obj;
    return
      date.equals(other.date) &&
      days == other.days;
  }
}

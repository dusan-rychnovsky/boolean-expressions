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
}

package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;

@lombok.Value
public class AddDays implements Value<LocalDate> {

  LocalDate date;
  int days;

  @Override
  public LocalDate getValue() {
    return date.plusDays(days);
  }
}

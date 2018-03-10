package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ExpressionTest {

  @Test
  public void simpleExpression()
  {
    assertTrue(
      new And(
        new Or(
          new Eq<>("ahoj", "hello"),
          new Lte<>(5, 5)
        ),
        new Gt<>(3, 1)
      ).evaluate()
    );
  }

  @Test
  public void dayDiffExpression() {
    assertTrue(
      new Eq<>(
        new DayDiff(
          new LocalDate(2012, 5, 10),
          new LocalDate(2017, 7, 4)
        ),
        new Const<>(1881)
      ).evaluate()
    );
  }

  @Test
  public void monthDiffExpression() {
    assertTrue(
      new Eq<>(
        new MonthDiff(
          new LocalDate(2012, 5, 10),
          new LocalDate(2017, 7, 4)
        ),
        new Const<>(61)
      ).evaluate()
    );
  }

  @Test
  public void yearDiffExpression() {
    assertTrue(
      new Lte<>(
        new YearDiff(
          new LocalDate(2012, 5, 10),
          new LocalDate(2017, 7, 4)
        ),
        new Const<>(5)
      ).evaluate()
    );
  }

  @Test
  public void addDaysExpression() {
    assertTrue(
      new Eq<>(
        new AddDays(
          new LocalDate(2017, 5, 25),
          10
        ),
        new Const<>(
          new LocalDate(2017, 6, 4)
        )
      ).evaluate()
    );
  }

  @Test
  public void dateEqExpression() {
    assertTrue(
      new Eq<>(
        new LocalDate(2018, 1, 5),
        new LocalDate(2018, 1, 5)
      ).evaluate()
    );
  }

  @Test
  public void dateLtExpression() {
    assertTrue(
      new Lt<>(
        new LocalDate(2018, 1, 5),
        new LocalDate(2018, 2, 5)
      ).evaluate()
    );
  }
}

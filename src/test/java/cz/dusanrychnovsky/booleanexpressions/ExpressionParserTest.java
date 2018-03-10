package cz.dusanrychnovsky.booleanexpressions;

import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExpressionParserTest {

  private final ExpressionParser parser = new ExpressionParser();

  @Test
  public void eq() throws ParseException {
    assertEquals(new Eq<>(42, 15), parser.parse("42 = 15"));
  }

  @Test
  public void lt() throws ParseException {
    assertEquals(new Lt<>(42, 15), parser.parse("42 < 15"));
  }

  @Test
  public void gt() throws ParseException {
    assertEquals(new Gt<>(42, 15), parser.parse("42 > 15"));
  }

  @Test
  public void gte() throws ParseException {
    assertEquals(new Gte<>(42, 15), parser.parse("42 >= 15"));
  }

  @Test
  public void lte() throws ParseException {
    assertEquals(new Lte<>(42, 15), parser.parse("42 <= 15"));
  }

  @Test
  public void and() throws ParseException {
    assertEquals(
      new And(
        new Eq<>(1, 2),
        new Eq<>(3, 4)
      ),
      parser.parse("1 = 2 AND 3 = 4")
    );
  }

  @Test
  public void or() throws ParseException {
    assertEquals(
      new Or(
        new Eq<>(1, 2),
        new Eq<>(3, 4)
      ),
      parser.parse("1 = 2 OR 3 = 4")
    );
  }

  @Test
  public void parRight() throws ParseException {
    assertEquals(
      new And(
        new Eq<>(1, 2),
        new And(
          new Eq<>(3, 4),
          new Eq<>(5, 6)
        )
      ),
      parser.parse("1 = 2 AND (3 = 4 AND 5 = 6)")
    );
  }

  @Test
  public void parLeft() throws ParseException {
    assertEquals(
      new And(
        new And(
          new Eq<>(1, 2),
          new Eq<>(3, 4)
        ),
        new Eq<>(5, 6)
      ),
      parser.parse("(1 = 2 AND 3 = 4) AND 5 = 6")
    );
  }

  @Test
  public void nestedPar() throws ParseException {
    assertEquals(
      new And(
        new And(
          new Eq<>(1, 2),
          new Eq<>(3, 4)
        ),
        new Eq<>(5, 6)
      ),
      parser.parse("((1 = 2 AND 3 = 4) AND 5 = 6)")
    );
  }

  @Test
  public void andOr() throws ParseException {
    assertEquals(
      new And(
        new Eq<>(1, 2),
        new Or(
          new Eq<>(3, 4),
          new Eq<>(5, 6)
        )
      ),
      parser.parse("1 = 2 AND (3 = 4 OR 5 = 6)")
    );
  }

  @Test
  public void orAnd() throws ParseException {
    assertEquals(
      new Or(
        new Eq<>(1, 2),
        new And(
          new Eq<>(3, 4),
          new Eq<>(5, 6)
        )
      ),
      parser.parse("1 = 2 OR (3 = 4 AND 5 = 6)")
    );
  }

  @Test
  public void dateEq() throws ParseException {
    assertEquals(
      new Eq<>(
        new LocalDate(2018, 3, 1),
        new LocalDate(2018, 3, 1)
      ),
      parser.parse("DATE(2018-03-01) = DATE(2018-03-01)")
    );
  }

  @Test
  public void dateLt() throws ParseException {
    assertEquals(
      new Lt<>(
        new LocalDate(2018, 3, 1),
        new LocalDate(2018, 3, 5)
      ),
      parser.parse("DATE(2018-03-01) < DATE(2018-03-05)")
    );
  }

  @Test(expected = ParseException.class)
  public void incompatibleTypes() throws ParseException {
    parser.parse("DATE(2018-03-01) = 15");
  }

  @Test
  public void dayDiff() throws ParseException {
    assertEquals(
      new Eq<>(
        new DayDiff(
          new LocalDate(2018, 1, 5),
          new LocalDate(2018, 1, 1)
        ),
        new Const<>(4)
      ),
      parser.parse("DAYDIFF(2018-01-05, 2018-01-01) = 4")
    );
  }

  @Test
  public void monthDiff() throws ParseException {
    assertEquals(
      new Eq<>(
        new MonthDiff(
          new LocalDate(2018, 1, 5),
          new LocalDate(2018, 10, 1)
        ),
        new Const<>(4)
      ),
      parser.parse("MONTHDIFF(2018-01-05, 2018-10-01) = 4")
    );
  }

  @Test
  public void yearDiff() throws ParseException {
    assertEquals(
      new Eq<>(
        new YearDiff(
          new LocalDate(2018, 1, 5),
          new LocalDate(2028, 10, 1)
        ),
        new Const<>(4)
      ),
      parser.parse("YEARDIFF(2018-01-05, 2028-10-01) = 4")
    );
  }

  @Test
  public void addDays() throws ParseException {
    assertEquals(
      new Eq<>(
        new AddDays(
          new LocalDate(2018, 1, 5),
          10
        ),
        new Const<>(new LocalDate(2018, 1, 15))
      ),
      parser.parse("ADDDAYS(2018-01-05, 10) = DATE(2018-01-15)")
    );
  }
}

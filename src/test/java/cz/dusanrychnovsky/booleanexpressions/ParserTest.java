package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParserTest {

  private final Parser parser = new Parser();

  @Test
  public void eq() throws ParseException {
    assertEquals(new Eq<>(42, 15), parser.parseExpression("42 = 15"));
  }

  @Test
  public void lt() throws ParseException {
    assertEquals(new Lt<>(42, 15), parser.parseExpression("42 < 15"));
  }

  @Test
  public void gt() throws ParseException {
    assertEquals(new Gt<>(42, 15), parser.parseExpression("42 > 15"));
  }

  @Test
  public void gte() throws ParseException {
    assertEquals(new Gte<>(42, 15), parser.parseExpression("42 >= 15"));
  }

  @Test
  public void lte() throws ParseException {
    assertEquals(new Lte<>(42, 15), parser.parseExpression("42 <= 15"));
  }

  @Test
  public void and() throws ParseException {
    assertEquals(
      new And(
        new Eq<>(1, 2),
        new Eq<>(3, 4)
      ),
      parser.parseExpression("1 = 2 AND 3 = 4")
    );
  }

  @Test
  public void or() throws ParseException {
    assertEquals(
      new Or(
        new Eq<>(1, 2),
        new Eq<>(3, 4)
      ),
      parser.parseExpression("1 = 2 OR 3 = 4")
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
      parser.parseExpression("1 = 2 AND (3 = 4 AND 5 = 6)")
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
      parser.parseExpression("(1 = 2 AND 3 = 4) AND 5 = 6")
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
      parser.parseExpression("((1 = 2 AND 3 = 4) AND 5 = 6)")
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
      parser.parseExpression("1 = 2 AND (3 = 4 OR 5 = 6)")
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
      parser.parseExpression("1 = 2 OR (3 = 4 AND 5 = 6)")
    );
  }
}

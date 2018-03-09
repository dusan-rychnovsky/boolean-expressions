package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Assert;
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
}

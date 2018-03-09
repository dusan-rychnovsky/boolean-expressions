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
}

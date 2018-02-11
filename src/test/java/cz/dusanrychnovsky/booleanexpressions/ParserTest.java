package cz.dusanrychnovsky.booleanexpressions;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

  private final Parser parser = new Parser();

  @Test
  public void simpleExpression() throws ParseException {
    Assert.assertEquals(3, parser.parseExpression("((("));
  }
}

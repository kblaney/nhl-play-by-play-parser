package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public final class GameNumToPlayByPlayUrlFunctionTest
{
  private GameNumToUrlFunction function;

  @Before
  public void setUp()
  {
    function = new GameNumToPlayByPlayUrlFunction();
  }

  @Test
  public void getUrl_OneDigitGameNum()
  {
    final int gameNum = 1;
    assertEquals("http://www.nhl.com/scores/htmlreports/20122013/PL020001.HTM", function.getUrl(gameNum));
  }

  @Test
  public void getUrl_TwoDigitGameNum()
  {
    final int gameNum = 23;
    assertEquals("http://www.nhl.com/scores/htmlreports/20122013/PL020023.HTM", function.getUrl(gameNum));
  }

  @Test
  public void getUrl_ThreeDigitGameNum()
  {
    final int gameNum = 317;
    assertEquals("http://www.nhl.com/scores/htmlreports/20122013/PL020317.HTM", function.getUrl(gameNum));
  }

  @Test
  public void getUrl_FourDigitGameNum()
  {
    final int gameNum = 9876;
    assertEquals("http://www.nhl.com/scores/htmlreports/20122013/PL029876.HTM", function.getUrl(gameNum));
  }
}

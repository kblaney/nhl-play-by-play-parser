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
  public void getUrl_OneDigitGameNumInRegularSeason20122013()
  {
    final int gameNum = 1;
    assertEquals("http://www.nhl.com/scores/htmlreports/20122013/PL020001.HTM",
          function.getUrl(Season.REGULAR_SEASON_2012_2013, gameNum));
  }

  @Test
  public void getUrl_TwoDigitGameNumInRegularSeason20112012()
  {
    final int gameNum = 23;
    assertEquals("http://www.nhl.com/scores/htmlreports/20112012/PL020023.HTM",
          function.getUrl(Season.REGULAR_SEASON_2011_2012, gameNum));
  }

  @Test
  public void getUrl_ThreeDigitGameNumInRegularSeason20122013()
  {
    final int gameNum = 317;
    assertEquals("http://www.nhl.com/scores/htmlreports/20122013/PL020317.HTM",
          function.getUrl(Season.REGULAR_SEASON_2012_2013, gameNum));
  }

  @Test
  public void getUrl_FourDigitGameNumInRegularSeason20112012()
  {
    final int gameNum = 9876;
    assertEquals("http://www.nhl.com/scores/htmlreports/20112012/PL029876.HTM",
          function.getUrl(Season.REGULAR_SEASON_2011_2012, gameNum));
  }
}

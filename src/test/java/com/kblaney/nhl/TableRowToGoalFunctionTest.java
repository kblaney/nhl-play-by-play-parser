package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.junit.Before;

public final class TableRowToGoalFunctionTest
{
  private TableRowToGameEventFunction<Goal> function;
  private int gameNum;

  @Before
  public void setUp()
  {
    function = new TableRowToGoalFunction();
    gameNum = 12;
  }

  @Test
  public void getGameEvent()
  {
    final int period = 1;
    final int numMinutesIntoPeriod = 2;
    final int numSecondsIntoMinute = 28;
    final Team winningTeam = Team.PITTSBURGH;
    final Element row = Jsoup.parseBodyFragment("<table><tr><td/><td>" + period + "</td><td/><td>" +
          numMinutesIntoPeriod + ":" + numSecondsIntoMinute + "</td><td>GOAL</td><td>" + winningTeam.getShortForm() +
          "</td></tr></table>");
    final int numSecondsIntoPeriod = (numMinutesIntoPeriod * 60) + numSecondsIntoMinute;
    assertEquals(new Goal(gameNum, period, numSecondsIntoPeriod, winningTeam), function.getGameEvent(row, gameNum));
  }
}

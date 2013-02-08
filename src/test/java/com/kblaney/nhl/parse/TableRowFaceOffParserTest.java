package com.kblaney.nhl.parse;

import static org.junit.Assert.*;
import com.kblaney.nhl.FaceOff;
import com.kblaney.nhl.FaceOffLocation;
import com.kblaney.nhl.Team;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;

public final class TableRowFaceOffParserTest
{
  private TableRowFaceOffParserImpl parser;
  private int gameNum;

  @Before
  public void setUp()
  {
    parser = new TableRowFaceOffParserImpl();
    gameNum = 12;
  }

  @Test
  public void getGameEvent_NeutralZoneFaceOff()
  {
    final int period = 1;
    final int numMinutesIntoPeriod = 3;
    final int numSecondsIntoMinute = 49;
    final Team winningTeam = Team.PITTSBURGH;
    final Element row = Jsoup.parseBodyFragment("<table><tr><td/><td>" + period + "</td><td/><td>" +
          numMinutesIntoPeriod + ":" + numSecondsIntoMinute + "</td><td>FAC</td><td>" + winningTeam.getShortForm() +
          " won Neu. Zone</td></tr></table>");
    final int numSecondsIntoPeriod = (numMinutesIntoPeriod * 60) + numSecondsIntoMinute;
    assertEquals(new FaceOff(gameNum, period, numSecondsIntoPeriod, FaceOffLocation.NEUTRAL_ZONE, winningTeam),
          parser.getGameEvent(row, gameNum));
  }

  @Test
  public void getGameEvent_FaceOffWonInOffensiveZone()
  {
    final int period = 2;
    final int numMinutesIntoPeriod = 11;
    final int numSecondsIntoMinute = 19;
    final Team winningTeam = Team.NEW_JERSEY;
    final Element row = Jsoup.parseBodyFragment("<table><tr><td/><td>" + period + "</td><td/><td>" +
          numMinutesIntoPeriod + ":" + numSecondsIntoMinute + "</td><td>FAC</td><td>" + winningTeam.getShortForm() +
          " won Off. Zone</td></tr></table>");
    final int numSecondsIntoPeriod = (numMinutesIntoPeriod * 60) + numSecondsIntoMinute;
    assertEquals(new FaceOff(gameNum, period, numSecondsIntoPeriod, FaceOffLocation.OFFENSIVE_ZONE, winningTeam),
          parser.getGameEvent(row, gameNum));
  }

  @Test
  public void getGameEvent_FaceOffWonInDefensiveZone()
  {
    final int period = 3;
    final int numMinutesIntoPeriod = 16;
    final int numSecondsIntoMinute = 59;
    final Team winningTeam = Team.OTTAWA;
    final Element row = Jsoup.parseBodyFragment("<table><tr><td/><td>" + period + "</td><td/><td>" +
          numMinutesIntoPeriod + ":" + numSecondsIntoMinute + "</td><td>FAC</td><td>" + winningTeam.getShortForm() +
          " won Def. Zone</td></tr></table>");
    final int numSecondsIntoPeriod = (numMinutesIntoPeriod * 60) + numSecondsIntoMinute;
    assertEquals(new FaceOff(gameNum, period, numSecondsIntoPeriod, FaceOffLocation.DEFENSIVE_ZONE, winningTeam),
          parser.getGameEvent(row, gameNum));
  }

  @Test
  public void getGameEvent_InvalidFaceOffLocation()
  {
    final Element row = Jsoup.parseBodyFragment("<table><tr><td/><td>3</td><td/><td>"
          + "16:59</td><td>FAC</td><td>OTT won XYZ Zone</td></tr></table>");
    try
    {
      parser.getGameEvent(row, gameNum);
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertTrue(e.getMessage().startsWith("Can't find face off location:"));
    }
  }

  @Test
  public void doesFaceOffHaveWinner_FaceOffHasWinner()
  {
    final Element row = Jsoup.parseBodyFragment("<table><tr><td/><td>1</td><td/><td>12:46"
          + "</td><td>FAC</td><td>OTT won Def. Zone</td></tr></table>");
    assertTrue(parser.doesFaceOffHaveWinner(row));
  }

  @Test
  public void doesFaceOffHaveWinner_FaceOffDoesNotHaveWinner()
  {
    final Element row = Jsoup.parseBodyFragment("<table><tr><td/><td>1</td><td/><td>12:46"
          + "</td><td>FAC</td><td>Neu. Zone</td></tr></table>");
    assertFalse(parser.doesFaceOffHaveWinner(row));
  }
}

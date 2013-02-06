package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Test;

public final class GameEventTableRowParserImplTest
{
  private GameEventTableRowParser parser;

  @Before
  public void setUp()
  {
    parser = new GameEventTableRowParserImpl();
  }

  @Test
  public void getEventType_FaceOff()
  {
    final Element row = getRowForEventType("FAC");
    assertEquals(GameEventType.FACE_OFF, parser.getEventType(row));
  }

  private Element getRowForEventType(final String eventTypeShortForm)
  {
    return Jsoup.parseBodyFragment("<table><tr><td/><td/><td/><td/><td>" + eventTypeShortForm + "</td></tr></table>");
  }

  @Test
  public void getEventType_Goal()
  {
    final Element row = getRowForEventType("GOAL");
    assertEquals(GameEventType.GOAL, parser.getEventType(row));
  }

  @Test
  public void getEventType_InvalidEventTypeShortForm()
  {
    final Element row = getRowForEventType("XYZ");
    try
    {
      parser.getEventType(row);
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("Unknown game event short form:XYZ", e.getMessage());
    }
  }

  @Test
  public void getPeriod_FirstPeriod()
  {
    final int period = 1;
    final Element row = getRowForPeriod(period);
    assertEquals(period, parser.getPeriod(row));
  }

  private Element getRowForPeriod(final int period)
  {
    return Jsoup.parseBodyFragment("<table><tr><td/><td>" + period + "</td></tr></table>");
  }

  @Test
  public void getPeriod_SecondPeriod()
  {
    final int period = 2;
    final Element row = getRowForPeriod(period);
    assertEquals(period, parser.getPeriod(row));
  }

  @Test
  public void getPeriod_ThirdPeriod()
  {
    final int period = 3;
    final Element row = getRowForPeriod(period);
    assertEquals(period, parser.getPeriod(row));
  }

  @Test
  public void getPeriod_FourthPeriod()
  {
    final int period = 4;
    final Element row = getRowForPeriod(period);
    assertEquals(period, parser.getPeriod(row));
  }

  @Test
  public void getPeriod_FifthPeriod()
  {
    final int period = 5;
    final Element row = getRowForPeriod(period);
    assertEquals(period, parser.getPeriod(row));
  }

  @Test
  public void getNumSecondsIntoPeriod_StartOfPeriod()
  {
    final Element row = getRowWithElapsedTime("0:00");
    assertEquals(0, parser.getNumSecondsIntoPeriod(row));
  }

  private Element getRowWithElapsedTime(final String elapsedTime)
  {
    return Jsoup.parseBodyFragment("<table><tr><td/><td/><td/><td>" + elapsedTime + "</td></tr></table>");
  }

  @Test
  public void getNumSecondsIntoPeriod_WithinFirstMinuteOfPeriod()
  {
    final Element row = getRowWithElapsedTime("0:29");
    assertEquals(29, parser.getNumSecondsIntoPeriod(row));
  }

  @Test
  public void getNumSecondsIntoPeriod_RightOnTheMinute()
  {
    final Element row = getRowWithElapsedTime("8:00");
    assertEquals(480, parser.getNumSecondsIntoPeriod(row));
  }

  @Test
  public void getNumSecondsIntoPeriod_DoubleDigitMinutes()
  {
    final Element row = getRowWithElapsedTime("11:46");
    assertEquals(706, parser.getNumSecondsIntoPeriod(row));
  }

  @Test
  public void getNumSecondsIntoPeriod_EndOfPeriod()
  {
    final Element row = getRowWithElapsedTime("20:00");
    assertEquals(1200, parser.getNumSecondsIntoPeriod(row));
  }

  @Test
  public void getNumSecondsIntoPeriod_InvalidElapsedTime()
  {
    final Element row = getRowWithElapsedTime("X:Y");
    try
    {
      parser.getNumSecondsIntoPeriod(row);
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertTrue(e.getMessage().startsWith("Can't find elapsed time in period:"));
    }
  }

  @Test
  public void getTeam_NoPeriodInTeamShortForm()
  {
    final Element row = getRowWithTeamShortForm("VAN");
    assertEquals(Team.VANCOUVER, parser.getTeam(row));
  }

  private Element getRowWithTeamShortForm(final String teamShortForm)
  {
    return Jsoup.parseBodyFragment("<table><tr><td/><td/><td/><td/><td/><td>" + teamShortForm + "</td></tr></table>");
  }

  @Test
  public void getTeam_PeriodInTeamShortForm()
  {
    final Element row = getRowWithTeamShortForm("S.J");
    assertEquals(Team.SAN_JOSE, parser.getTeam(row));
  }

  @Test
  public void getNumSecondsIntoPeriod_NoTeamShortForm()
  {
    final Element row = getRowWithTeamShortForm("");
    try
    {
      parser.getTeam(row);
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertTrue(e.getMessage().startsWith("Can't find team short form:"));
    }
  }

  @Test
  public void getNumSecondsIntoPeriod_UnknownTeamShortForm()
  {
    final Element row = getRowWithTeamShortForm("XYZ");
    try
    {
      parser.getTeam(row);
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertEquals("Unknown team short form:XYZ", e.getMessage());
    }
  }
}

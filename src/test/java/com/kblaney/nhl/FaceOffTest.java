package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.joda.time.Duration;

public final class FaceOffTest
{
  private int gameNum;
  private int period;
  private Duration elapsedTimeInPeriod;
  private FaceOffLocation location;
  private Team defensiveTeam;
  private Team winningTeam;
  private FaceOff faceOff;

  @Before
  public void setUp()
  {
    gameNum = 2;
    period = 3;
    elapsedTimeInPeriod = Duration.standardMinutes(4);
    location = FaceOffLocation.DEFENSIVE_ZONE;
    defensiveTeam = Team.ANAHEIM;
    winningTeam = Team.VANCOUVER;
    faceOff = new FaceOff(gameNum, period, elapsedTimeInPeriod, location, defensiveTeam, winningTeam);
  }

  @Test
  public void getGameNum()
  {
    assertEquals(gameNum, faceOff.getGameNum());
  }

  @Test
  public void getType()
  {
    assertEquals(GameEventType.FACE_OFF, faceOff.getEventType());
  }

  @Test
  public void getPeriod()
  {
    assertEquals(period, faceOff.getPeriod());
  }

  @Test
  public void getElapsedTimeInPeriod()
  {
    assertEquals(elapsedTimeInPeriod, faceOff.getElapsedTimeInPeriod());
  }

  @Test
  public void getLocation()
  {
    assertEquals(location, faceOff.getLocation());
  }

  @Test
  public void getDefensiveTeam()
  {
    assertEquals(defensiveTeam, faceOff.getDefensiveTeam());
  }

  @Test
  public void getWinningTeam()
  {
    assertEquals(winningTeam, faceOff.getWinningTeam());
  }
}
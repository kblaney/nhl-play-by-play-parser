package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public final class FaceOffTest
{
  private int gameNum;
  private int period;
  private int numSecondsIntoPeriod;
  private FaceOffLocation location;
  private Team winningTeam;
  private FaceOff faceOff;

  @Before
  public void setUp()
  {
    gameNum = 2;
    period = 3;
    numSecondsIntoPeriod = 129;
    location = FaceOffLocation.DEFENSIVE_ZONE;
    winningTeam = Team.VANCOUVER;
    faceOff = new FaceOff(gameNum, period, numSecondsIntoPeriod, location, winningTeam);
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
  public void getNumSecondsIntoPeriod()
  {
    assertEquals(numSecondsIntoPeriod, faceOff.getNumSecondsIntoPeriod());
  }

  @Test
  public void getLocation()
  {
    assertEquals(location, faceOff.getLocation());
  }

  @Test
  public void getWinningTeam()
  {
    assertEquals(winningTeam, faceOff.getWinningTeam());
  }
}

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

  @Test
  public void equals_Null()
  {
    assertFalse(faceOff.equals(null));
  }

  @Test
  public void equals_String()
  {
    assertFalse(faceOff.equals("This string is not equal to a FaceOff"));
  }

  @Test
  public void equals_Goal()
  {
    final GameEvent goal = new Goal(gameNum, period, numSecondsIntoPeriod, Team.VANCOUVER);
    assertFalse(faceOff.equals(goal));
  }

  @Test
  public void equals_DifferentGamNum()
  {
    final int differentGameNum = gameNum + 1;
    final FaceOff unequalFaceOff = new FaceOff(differentGameNum, period, numSecondsIntoPeriod, location, winningTeam);
    assertFalse(faceOff.equals(unequalFaceOff));
  }

  @Test
  public void equals_DifferentPeriod()
  {
    final int differentPeriod = period + 1;
    final FaceOff unequalFaceOff = new FaceOff(gameNum, differentPeriod, numSecondsIntoPeriod, location, winningTeam);
    assertFalse(faceOff.equals(unequalFaceOff));
  }

  @Test
  public void equals_DifferentNumSecondsIntoPeriod()
  {
    final int differentNumSecondsIntoPeriod = numSecondsIntoPeriod + 1;
    final FaceOff unequalFaceOff = new FaceOff(gameNum, period, differentNumSecondsIntoPeriod, location, winningTeam);
    assertFalse(faceOff.equals(unequalFaceOff));
  }

  @Test
  public void equals_DifferentLocation()
  {
    location = FaceOffLocation.DEFENSIVE_ZONE;
    faceOff = new FaceOff(gameNum, period, numSecondsIntoPeriod, location, winningTeam);
    final FaceOffLocation differentLocation = FaceOffLocation.OFFENSIVE_ZONE;
    final FaceOff unequalFaceOff = new FaceOff(gameNum, period, numSecondsIntoPeriod, differentLocation, winningTeam);
    assertFalse(faceOff.equals(unequalFaceOff));
  }

  @Test
  public void equals_DifferentWinningTeam()
  {
    winningTeam = Team.BUFFALO;
    faceOff = new FaceOff(gameNum, period, numSecondsIntoPeriod, location, winningTeam);
    final Team differentWinningTeam = Team.COLUMBUS;
    final FaceOff unequalFaceOff = new FaceOff(gameNum, period, numSecondsIntoPeriod, location, differentWinningTeam);
    assertFalse(faceOff.equals(unequalFaceOff));
  }

  @Test
  public void equals_EqualInstances()
  {
    final FaceOff equalFaceOff = new FaceOff(gameNum, period, numSecondsIntoPeriod, location, winningTeam);
    assertTrue(faceOff.equals(equalFaceOff));
  }

  @Test
  public void hashCode_EqualInstances()
  {
    final FaceOff equalFaceOff = new FaceOff(gameNum, period, numSecondsIntoPeriod, location, winningTeam);
    assertEquals(faceOff.hashCode(), equalFaceOff.hashCode());
  }
}

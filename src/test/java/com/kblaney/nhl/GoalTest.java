package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public final class GoalTest
{
  private int gameNum;
  private int period;
  private int numSecondsIntoPeriod;
  private Team scoringTeam;
  private Goal goal;

  @Before
  public void setUp()
  {
    gameNum = 2;
    period = 3;
    numSecondsIntoPeriod = 334;
    scoringTeam = Team.BUFFALO;
    goal = new Goal(gameNum, period, numSecondsIntoPeriod, scoringTeam);
  }

  @Test
  public void getGameNum()
  {
    assertEquals(gameNum, goal.getGameNum());
  }

  @Test
  public void getType()
  {
    assertEquals(GameEventType.GOAL, goal.getEventType());
  }

  @Test
  public void getPeriod()
  {
    assertEquals(period, goal.getPeriod());
  }

  @Test
  public void getNumSecondsIntoPeriod()
  {
    assertEquals(numSecondsIntoPeriod, goal.getNumSecondsIntoPeriod());
  }

  @Test
  public void getDefensiveTeam()
  {
    assertEquals(scoringTeam, goal.getScoringTeam());
  }

  @Test
  public void equals_Null()
  {
    assertFalse(goal.equals(null));
  }

  @Test
  public void equals_String()
  {
    assertFalse(goal.equals("This string is not equal to a Goal"));
  }

  @Test
  public void equals_FaceOff()
  {
    final GameEvent faceOff = new FaceOff(gameNum, period, numSecondsIntoPeriod, FaceOffLocation.NEUTRAL_ZONE, Team.VANCOUVER);
    assertFalse(goal.equals(faceOff));
  }

  @Test
  public void equals_DifferentGamNum()
  {
    final int differentGameNum = gameNum + 1;
    final Goal unequalGoal = new Goal(differentGameNum, period, numSecondsIntoPeriod, scoringTeam);
    assertFalse(goal.equals(unequalGoal));
  }

  @Test
  public void equals_DifferentPeriod()
  {
    final int differentPeriod = period + 1;
    final Goal unequalGoal = new Goal(gameNum, differentPeriod, numSecondsIntoPeriod, scoringTeam);
    assertFalse(goal.equals(unequalGoal));
  }

  @Test
  public void equals_DifferentNumSecondsIntoPeriod()
  {
    final int differentNumSecondsIntoPeriod = numSecondsIntoPeriod + 1;
    final Goal unequalGoal = new Goal(gameNum, period, differentNumSecondsIntoPeriod, scoringTeam);
    assertFalse(goal.equals(unequalGoal));
  }

  @Test
  public void equals_DifferentScoringTeam()
  {
    scoringTeam = Team.BUFFALO;
    goal = new Goal(gameNum, period, numSecondsIntoPeriod, scoringTeam);
    final Team differentScoringTeam = Team.VANCOUVER;
    final Goal unequalGoal = new Goal(gameNum, period, numSecondsIntoPeriod, differentScoringTeam);
    assertFalse(goal.equals(unequalGoal));
  }

  @Test
  public void equals_EqualInstances()
  {
    final Goal equalGoal = new Goal(gameNum, period, numSecondsIntoPeriod, scoringTeam);
    assertTrue(goal.equals(equalGoal));
  }

  @Test
  public void hashCode_EqualInstances()
  {
    final Goal equalGoal = new Goal(gameNum, period, numSecondsIntoPeriod, scoringTeam);
    assertEquals(goal.hashCode(), equalGoal.hashCode());
  }
}

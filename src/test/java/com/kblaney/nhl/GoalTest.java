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
}

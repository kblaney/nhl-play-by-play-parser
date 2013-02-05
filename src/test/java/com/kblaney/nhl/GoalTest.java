package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.joda.time.Duration;

public final class GoalTest
{
  private int gameNum;
  private int period;
  private Duration elapsedTimeInPeriod;
  private Team scoringTeam;
  private Goal goal;

  @Before
  public void setUp()
  {
    gameNum = 2;
    period = 3;
    elapsedTimeInPeriod = Duration.standardMinutes(4);
    scoringTeam = Team.BUFFALO;
    goal = new Goal(gameNum, period, elapsedTimeInPeriod, scoringTeam);
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
  public void getElapsedTimeInPeriod()
  {
    assertEquals(elapsedTimeInPeriod, goal.getElapsedTimeInPeriod());
  }

  @Test
  public void getDefensiveTeam()
  {
    assertEquals(scoringTeam, goal.getScoringTeam());
  }
}

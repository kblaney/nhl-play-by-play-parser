package com.kblaney.nhl;

import org.joda.time.Duration;

public final class Goal extends AbstractGameEvent implements GameEvent
{
  private final Team scoringTeam;

  public Goal(final int gameNum, final int period, final Duration elapsedTimeInPeriod, final Team scoringTeam)
  {
    super(gameNum, GameEventType.GOAL, period, elapsedTimeInPeriod);
    this.scoringTeam = scoringTeam;
  }

  public Team getScoringTeam()
  {
    return scoringTeam;
  }
}

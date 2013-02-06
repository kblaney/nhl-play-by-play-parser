package com.kblaney.nhl;

public final class Goal extends AbstractGameEvent implements GameEvent
{
  private final Team scoringTeam;

  public Goal(final int gameNum, final int period, final int numSecondsIntoPeriod, final Team scoringTeam)
  {
    super(gameNum, GameEventType.GOAL, period, numSecondsIntoPeriod);
    this.scoringTeam = scoringTeam;
  }

  public Team getScoringTeam()
  {
    return scoringTeam;
  }
}

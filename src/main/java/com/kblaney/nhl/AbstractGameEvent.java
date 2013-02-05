package com.kblaney.nhl;

import org.joda.time.Duration;

public abstract class AbstractGameEvent implements GameEvent
{
  private final int gameNum;
  private final GameEventType type;
  private final int period;
  private final Duration elapsedTimeInPeriod;

  public AbstractGameEvent(final int gameNum, final GameEventType type, final int period,
        final Duration elapsedTimeInPeriod)
  {
    this.gameNum = gameNum;
    this.type = type;
    this.period = period;
    this.elapsedTimeInPeriod = elapsedTimeInPeriod;
  }

  public final int getGameNum()
  {
    return gameNum;
  }

  public final GameEventType getEventType()
  {
    return type;
  }

  public final int getPeriod()
  {
    return period;
  }

  public final Duration getElapsedTimeInPeriod()
  {
    return elapsedTimeInPeriod;
  }
}

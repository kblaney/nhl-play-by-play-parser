package com.kblaney.nhl;

public abstract class AbstractGameEvent implements GameEvent
{
  private final int gameNum;
  private final GameEventType type;
  private final int period;
  private final int numSecondsIntoPeriod;

  public AbstractGameEvent(final int gameNum, final GameEventType type, final int period,
        final int numSecondsIntoPeriod)
  {
    this.gameNum = gameNum;
    this.type = type;
    this.period = period;
    this.numSecondsIntoPeriod = numSecondsIntoPeriod;
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

  public final int getNumSecondsIntoPeriod()
  {
    return numSecondsIntoPeriod;
  }
}

package com.kblaney.nhl;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

public abstract class AbstractGameEvent implements GameEvent
{
  private final int gameNum;
  private final GameEventType type;
  private final int period;
  private final int numSecondsIntoPeriod;

  public AbstractGameEvent(final int gameNum, final GameEventType type, final int period, final int numSecondsIntoPeriod)
  {
    this.gameNum = gameNum;
    this.type = type;
    this.period = period;
    this.numSecondsIntoPeriod = numSecondsIntoPeriod;
  }

  @Override
  public final int getGameNum()
  {
    return gameNum;
  }

  @Override
  public final GameEventType getEventType()
  {
    return type;
  }

  @Override
  public final int getPeriod()
  {
    return period;
  }

  @Override
  public final int getNumSecondsIntoPeriod()
  {
    return numSecondsIntoPeriod;
  }

  @Override
  public boolean equals(final Object thatObject)
  {
    if (!(thatObject instanceof GameEvent))
    {
      return false;
    }
    final GameEvent that = (GameEvent) thatObject;
    return new EqualsBuilder().append(type, that.getEventType()).append(gameNum, that.getGameNum())
          .append(period, that.getPeriod()).append(numSecondsIntoPeriod, that.getNumSecondsIntoPeriod()).isEquals();
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder().append(type).append(gameNum).append(period).append(numSecondsIntoPeriod).toHashCode();
  }
}

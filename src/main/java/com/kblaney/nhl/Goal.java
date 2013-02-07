package com.kblaney.nhl;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

  @Override
  public boolean equals(final Object thatObject)
  {
    if (!(thatObject instanceof Goal))
    {
      return false;
    }
    final Goal that = (Goal) thatObject;
    return new EqualsBuilder().appendSuper(super.equals(that)).append(scoringTeam, that.scoringTeam).isEquals();
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(scoringTeam).toHashCode();
  }

  @Override
  public String toString()
  {
    return Joiner.on(',').join(super.toCsvString(), scoringTeam);
  }
}

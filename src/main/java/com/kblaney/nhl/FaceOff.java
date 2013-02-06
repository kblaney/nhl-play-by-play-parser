package com.kblaney.nhl;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class FaceOff extends AbstractGameEvent implements GameEvent
{
  private final FaceOffLocation location;
  private final Team winningTeam;

  public FaceOff(final int gameNum, final int period, final int numSecondsIntoPeriod, final FaceOffLocation location,
        final Team winningTeam)
  {
    super(gameNum, GameEventType.FACE_OFF, period, numSecondsIntoPeriod);
    this.location = location;
    this.winningTeam = winningTeam;
  }

  public FaceOffLocation getLocation()
  {
    return location;
  }

  public Team getWinningTeam()
  {
    return winningTeam;
  }

  @Override
  public boolean equals(final Object thatObject)
  {
    if (!(thatObject instanceof FaceOff))
    {
      return false;
    }
    final FaceOff that = (FaceOff) thatObject;
    return new EqualsBuilder().appendSuper(super.equals(that)).append(location, that.location)
          .append(winningTeam, that.winningTeam).isEquals();
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(location).append(winningTeam).toHashCode();
  }

  @Override
  public String toString()
  {
    return Joiner.on(',').join(super.toCsvString(), location, winningTeam);
  }
}

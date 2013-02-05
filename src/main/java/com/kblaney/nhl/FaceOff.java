package com.kblaney.nhl;

import org.joda.time.Duration;

public final class FaceOff extends AbstractGameEvent implements GameEvent
{
  private final FaceOffLocation location;
  private final Team defensiveTeam;
  private final Team winningTeam;

  public FaceOff(final int gameNum, final int period, final Duration elapsedTimeInPeriod,
        final FaceOffLocation location, final Team defensiveTeam, final Team winningTeam)
  {
    super(gameNum, GameEventType.FACE_OFF, period, elapsedTimeInPeriod);
    this.location = location;
    this.defensiveTeam = defensiveTeam;
    this.winningTeam = winningTeam;
  }

  public FaceOffLocation getLocation()
  {
    return location;
  }

  public Team getDefensiveTeam()
  {
    return defensiveTeam;
  }

  public Team getWinningTeam()
  {
    return winningTeam;
  }
}

package com.kblaney.nhl;

import com.google.common.base.Optional;

public final class FaceOff extends AbstractGameEvent implements GameEvent
{
  private final FaceOffLocation location;
  private final Optional<Team> defensiveTeam;
  private final Team winningTeam;

  public FaceOff(final int gameNum, final int period, final int numSecondsIntoPeriod,
        final FaceOffLocation location, final Optional<Team> defensiveTeam, final Team winningTeam)
  {
    super(gameNum, GameEventType.FACE_OFF, period, numSecondsIntoPeriod);
    this.location = location;
    this.defensiveTeam = defensiveTeam;
    this.winningTeam = winningTeam;
  }

  public FaceOffLocation getLocation()
  {
    return location;
  }

  public Optional<Team> getDefensiveTeam()
  {
    return defensiveTeam;
  }

  public Team getWinningTeam()
  {
    return winningTeam;
  }
}

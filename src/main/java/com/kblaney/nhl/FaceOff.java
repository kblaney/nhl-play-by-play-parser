package com.kblaney.nhl;

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
}

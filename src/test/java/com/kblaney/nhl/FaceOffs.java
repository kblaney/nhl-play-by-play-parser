package com.kblaney.nhl;

public final class FaceOffs
{
  public static final FaceOff NEUTRAL_ZONE_FACE_OFF = getFaceOffIn(FaceOffLocation.NEUTRAL_ZONE);

  private static final FaceOff getFaceOffIn(final FaceOffLocation location)
  {
    final int GAME_NUM = 1;
    final int PERIOD = 1;
    final int NUM_SECONDS_INTO_PERIOD = 60;
    final Team WINNING_TEAM = Team.VANCOUVER;
    return new FaceOff(GAME_NUM, PERIOD, NUM_SECONDS_INTO_PERIOD, location, WINNING_TEAM);
  }

  public static final FaceOff OFFENSIVE_ZONE_FACE_OFF = getFaceOffIn(FaceOffLocation.OFFENSIVE_ZONE);

  public static final FaceOff DEFENSIVE_ZONE_FACE_OFF = getFaceOffIn(FaceOffLocation.DEFENSIVE_ZONE);
}

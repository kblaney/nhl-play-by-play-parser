package com.kblaney.nhl;

public enum GameEventType
{
  PERIOD_START("PSTR"),
  PERIOD_END("PEND"),
  FACE_OFF("FAC"),
  GOAL("GOAL"),
  PENALTY("PENL"),
  SHOT_ON_GOAL("SHOT"),
  MISSED_SHOT("MISS"),
  BLOCKED_SHOT("BLOCK"),
  GIVEAWAY("GIVE"),
  TAKEAWAY("TAKE"),
  HIT("HIT"),
  STOPPAGE_IN_PLAY("STOP");

  private final String shortForm;

  private GameEventType(final String shortForm)
  {
    this.shortForm = shortForm;
  }

  public static GameEventType fromShortForm(final String shortForm)
  {
    for (final GameEventType gameEventType : values())
    {
      if (gameEventType.shortForm.equals(shortForm))
      {
        return gameEventType;
      }
    }
    throw new IllegalArgumentException("Unknown short form:" + shortForm);
  }
}

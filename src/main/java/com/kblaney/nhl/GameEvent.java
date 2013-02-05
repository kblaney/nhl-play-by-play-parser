package com.kblaney.nhl;

import org.joda.time.Duration;

public interface GameEvent
{
  int getGameNum();
  GameEventType getEventType();
  int getPeriod();
  Duration getElapsedTimeInPeriod();
}

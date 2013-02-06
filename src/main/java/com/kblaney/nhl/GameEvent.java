package com.kblaney.nhl;

public interface GameEvent
{
  int getGameNum();
  GameEventType getEventType();
  int getPeriod();
  int getNumSecondsIntoPeriod();
}

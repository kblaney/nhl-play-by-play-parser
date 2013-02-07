package com.kblaney.nhl;

import java.io.IOException;
import java.util.List;

public interface GameNumToEventsFunction
{
  List<GameEvent> getGameEvents(Season season, int gameNum) throws IOException;
}

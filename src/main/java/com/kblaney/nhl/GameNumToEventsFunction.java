package com.kblaney.nhl;

import java.io.IOException;
import java.util.List;

public interface GameNumToEventsFunction
{
  List<GameEvent> getGameEvents(int gameNum) throws IOException;
}

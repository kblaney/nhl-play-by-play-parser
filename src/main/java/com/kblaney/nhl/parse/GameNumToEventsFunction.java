package com.kblaney.nhl.parse;

import com.kblaney.nhl.GameEvent;
import com.kblaney.nhl.Season;
import java.io.IOException;
import java.util.List;

public interface GameNumToEventsFunction
{
  List<GameEvent> getGameEvents(Season season, int gameNum) throws IOException;
}

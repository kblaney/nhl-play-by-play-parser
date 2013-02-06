package com.kblaney.nhl;

import org.jsoup.nodes.Element;

public interface TableRowToGameEventFunction<T extends GameEvent>
{
  T getGameEvent(Element tableRow, int gameNum);
}

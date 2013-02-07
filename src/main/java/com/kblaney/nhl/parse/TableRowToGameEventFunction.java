package com.kblaney.nhl.parse;

import com.kblaney.nhl.GameEvent;
import org.jsoup.nodes.Element;

interface TableRowToGameEventFunction<T extends GameEvent>
{
  T getGameEvent(Element tableRow, int gameNum);
}

package com.kblaney.nhl;

import org.jsoup.nodes.Element;

public interface GameEventTableRowParser
{
  GameEventType getEventType(Element gameEventTableRow);

  int getPeriod(Element gameEventTableRow);

  int getNumSecondsIntoPeriod(Element gameEventTableRow);

  Team getTeam(Element gameEventTableRow);
}

package com.kblaney.nhl.parse;

import com.kblaney.nhl.GameEventType;
import com.kblaney.nhl.Team;
import org.jsoup.nodes.Element;

interface GameEventTableRowParser
{
  GameEventType getEventType(Element gameEventTableRow);

  int getPeriod(Element gameEventTableRow);

  int getNumSecondsIntoPeriod(Element gameEventTableRow);

  Team getTeam(Element gameEventTableRow);
}

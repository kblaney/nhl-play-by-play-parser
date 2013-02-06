package com.kblaney.nhl;

import org.jsoup.nodes.Element;

public interface GameEventTableRowParser
{
  int getPeriod(Element gameEventTableRow);

  int getNumSecondsIntoPeriod(Element gameEventTableRow);
}

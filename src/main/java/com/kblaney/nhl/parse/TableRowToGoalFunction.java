package com.kblaney.nhl.parse;

import com.kblaney.nhl.Goal;
import com.kblaney.nhl.Team;
import org.jsoup.nodes.Element;

class TableRowToGoalFunction implements TableRowToGameEventFunction<Goal>
{
  private final GameEventTableRowParser tableRowParser = new GameEventTableRowParserImpl();

  @Override
  public Goal getGameEvent(final Element tableRow, final int gameNum)
  {
    final int period = getPeriod(tableRow);
    final int numSecondsIntoPeriod = getNumSecondsIntoPeriod(tableRow);
    final Team scoringTeam = getScoringTeam(tableRow);
    return new Goal(gameNum, period, numSecondsIntoPeriod, scoringTeam);
  }

  private int getPeriod(final Element tableRow)
  {
    return tableRowParser.getPeriod(tableRow);
  }

  private int getNumSecondsIntoPeriod(final Element tableRow)
  {
    return tableRowParser.getNumSecondsIntoPeriod(tableRow);
  }

  private Team getScoringTeam(final Element tableRow)
  {
    return tableRowParser.getTeam(tableRow);
  }
}

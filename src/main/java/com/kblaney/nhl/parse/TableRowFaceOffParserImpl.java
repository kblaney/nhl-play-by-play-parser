package com.kblaney.nhl.parse;

import com.kblaney.nhl.FaceOff;
import com.kblaney.nhl.FaceOffLocation;
import com.kblaney.nhl.Team;
import org.jsoup.nodes.Element;

class TableRowFaceOffParserImpl implements TableRowToGameEventFunction<FaceOff>, TableRowFaceOffParser
{
  private final GameEventTableRowParser tableRowParser = new GameEventTableRowParserImpl();

  @Override
  public FaceOff getGameEvent(final Element tableRow, final int gameNum)
  {
    final int period = getPeriod(tableRow);
    final int numSecondsIntoPeriod = getNumSecondsIntoPeriod(tableRow);
    final FaceOffLocation location = getFaceOffLocation(tableRow);
    final Team winningTeam = getWinningTeam(tableRow);
    return new FaceOff(gameNum, period, numSecondsIntoPeriod, location, winningTeam);
  }

  private int getPeriod(final Element tableRow)
  {
    return tableRowParser.getPeriod(tableRow);
  }

  private int getNumSecondsIntoPeriod(final Element tableRow)
  {
    return tableRowParser.getNumSecondsIntoPeriod(tableRow);
  }

  private FaceOffLocation getFaceOffLocation(final Element tableRow)
  {
    if (tableRow.text().contains("won Neu. Zone"))
    {
      return FaceOffLocation.NEUTRAL_ZONE;
    }
    else if (tableRow.text().contains("won Def. Zone"))
    {
      return FaceOffLocation.DEFENSIVE_ZONE;
    }
    else if (tableRow.text().contains("won Off. Zone"))
    {
      return FaceOffLocation.OFFENSIVE_ZONE;
    }
    throw new IllegalArgumentException("Can't find face off location:" + tableRow);
  }

  private Team getWinningTeam(final Element tableRow)
  {
    return tableRowParser.getTeam(tableRow);
  }

  @Override
  public boolean doesFaceOffHaveWinner(final Element faceOffTableRow)
  {
    return faceOffTableRow.text().contains("won ");
  }
}

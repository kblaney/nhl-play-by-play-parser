package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentToFaceOffsFunctionImpl implements DocumentToFaceOffsFunction
{
  private final GameEventTableRowParser tableRowParser = new GameEventTableRowParserImpl();

  @Override
  public List<FaceOff> getFaceOffs(final Document document, final int gameNum)
  {
    final Elements faceOffTableRows = getFaceOffTableRows(document);
    final List<FaceOff> faceOffs = Lists.newArrayList();
    for (final Element faceOffTableRow : faceOffTableRows)
    {
      faceOffs.add(getFaceOff(faceOffTableRow, gameNum));
    }
    return faceOffs;
  }

  private Elements getFaceOffTableRows(final Document document)
  {
    final List<Element> faceOffTableRows = Lists.newArrayList();
    final Elements faceOffTableCells = document.select("td:matchesOwn(^FAC$");
    for (final Element faceOffTableCell : faceOffTableCells)
    {
      faceOffTableRows.add(faceOffTableCell.parent());
    }
    return new Elements(faceOffTableRows);
  }

  private FaceOff getFaceOff(final Element faceOffTableRow, final int gameNum)
  {
    final int period = getPeriod(faceOffTableRow);
    final int numSecondsIntoPeriod = getNumSecondsIntoPeriod(faceOffTableRow);
    final FaceOffLocation location = getFaceOffLocation(faceOffTableRow);
    final Team winningTeam = getWinningTeam(faceOffTableRow);
    return new FaceOff(gameNum, period, numSecondsIntoPeriod, location, winningTeam);
  }

  private int getPeriod(final Element faceOffTableRow)
  {
    return tableRowParser.getPeriod(faceOffTableRow);
  }

  private int getNumSecondsIntoPeriod(final Element faceOffTableRow)
  {
    return tableRowParser.getNumSecondsIntoPeriod(faceOffTableRow);
  }

  private FaceOffLocation getFaceOffLocation(final Element faceOffTableRow)
  {
    if (faceOffTableRow.text().contains("won Neu. Zone"))
    {
      return FaceOffLocation.NEUTRAL_ZONE;
    }
    else if (faceOffTableRow.text().contains("won Def. Zone"))
    {
      return FaceOffLocation.DEFENSIVE_ZONE;
    }
    else if (faceOffTableRow.text().contains("won Off. Zone"))
    {
      return FaceOffLocation.OFFENSIVE_ZONE;
    }
    throw new IllegalArgumentException("Can't find face off location:" + faceOffTableRow);
  }

  private Team getWinningTeam(final Element faceOffTableRow)
  {
    return tableRowParser.getTeam(faceOffTableRow);
  }
}

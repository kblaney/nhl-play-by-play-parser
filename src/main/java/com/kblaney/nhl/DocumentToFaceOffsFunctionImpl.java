package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentToFaceOffsFunctionImpl implements DocumentToFaceOffsFunction
{
  private final TableRowToGameEventFunction<FaceOff> tableRowToFaceOffFunction = new TableRowToFaceOffFunction();

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
    return tableRowToFaceOffFunction.getGameEvent(faceOffTableRow, gameNum);
  }
}

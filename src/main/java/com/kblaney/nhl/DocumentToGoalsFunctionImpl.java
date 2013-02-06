package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentToGoalsFunctionImpl implements DocumentToGoalsFunction
{
  private final TableRowToGameEventFunction<Goal> tableRowtoGoalFunction = new TableRowToGoalFunction();

  @Override
  public List<Goal> getGoals(final Document document, final int gameNum)
  {
    final Elements goalTableRows = getGoalTableRows(document);
    final List<Goal> goals = Lists.newArrayList();
    for (final Element goalTableRow : goalTableRows)
    {
      goals.add(getGoal(goalTableRow, gameNum));
    }
    return goals;
  }

  private Elements getGoalTableRows(final Document document)
  {
    final List<Element> goalRows = Lists.newArrayList();
    final Elements goalTableCells = document.select("td:matchesOwn(^GOAL$");
    for (final Element goalTableCell : goalTableCells)
    {
      goalRows.add(goalTableCell.parent());
    }
    return new Elements(goalRows);
  }

  private Goal getGoal(final Element goalTableRow, final int gameNum)
  {
    return tableRowtoGoalFunction.getGameEvent(goalTableRow, gameNum);
  }
}

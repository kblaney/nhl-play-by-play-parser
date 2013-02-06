package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentToGoalsFunctionImpl implements DocumentToGoalsFunction
{
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
    final int period = getPeriod(goalTableRow);
    final int numSecondsIntoPeriod = getNumSecondsIntoPeriod(goalTableRow);
    final Team scoringTeam = getScoringTeam(goalTableRow);
    return new Goal(gameNum, period, numSecondsIntoPeriod, scoringTeam);
  }

  private int getPeriod(final Element goalTableRow)
  {
    final String cellText = goalTableRow.select("td:eq(1)").first().text();
    return Integer.parseInt(cellText);
  }

  private int getNumSecondsIntoPeriod(final Element goalTableRow)
  {
    final String cellText = goalTableRow.select("td:eq(3)").first().text();
    final Pattern pattern = Pattern.compile("(\\d+):(\\d+)");
    final Matcher matcher = pattern.matcher(cellText);
    if (matcher.find())
    {
      final int numMinutes = Integer.parseInt(matcher.group(1));
      final int numSeconds = Integer.parseInt(matcher.group(2));
      return (numMinutes * 60) + numSeconds;
    }
    throw new IllegalArgumentException("Can't find elapsed time in period:" + goalTableRow);
  }

  private Team getScoringTeam(Element goalTableRow)
  {
    final String cellText = goalTableRow.select("td:eq(5)").first().text();
    final Pattern pattern = Pattern.compile("^(\\S+)");
    final Matcher matcher = pattern.matcher(cellText);
    if (matcher.find())
    {
      return Team.fromShortForm(matcher.group(1));
    }
    throw new IllegalArgumentException("Can't find team:" + goalTableRow);
  }
}

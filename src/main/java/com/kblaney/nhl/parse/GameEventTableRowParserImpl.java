package com.kblaney.nhl.parse;

import com.kblaney.nhl.GameEventType;
import com.kblaney.nhl.Team;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Element;

class GameEventTableRowParserImpl implements GameEventTableRowParser
{
  @Override
  public GameEventType getEventType(final Element gameEventTableRow)
  {
    final String eventShortForm = gameEventTableRow.select("td:eq(4)").first().text();
    return GameEventType.fromShortForm(eventShortForm);
  }

  @Override
  public int getPeriod(final Element gameEventTableRow)
  {
    final String cellText = gameEventTableRow.select("td:eq(1)").first().text();
    return Integer.parseInt(cellText);
  }

  @Override
  public int getNumSecondsIntoPeriod(final Element gameEventTableRow)
  {
    final String cellText = gameEventTableRow.select("td:eq(3)").first().text();
    final Pattern pattern = Pattern.compile("(\\d+):(\\d+)");
    final Matcher matcher = pattern.matcher(cellText);
    if (matcher.find())
    {
      final int numMinutes = Integer.parseInt(matcher.group(1));
      final int numSeconds = Integer.parseInt(matcher.group(2));
      final int numSecondsPerMinute = 60;
      return (numMinutes * numSecondsPerMinute) + numSeconds;
    }
    throw new IllegalArgumentException("Can't find elapsed time in period:" + gameEventTableRow);
  }

  @Override
  public Team getTeam(final Element gameEventTableRow)
  {
    final String cellText = gameEventTableRow.select("td:eq(5)").first().text();
    final Pattern pattern = Pattern.compile("^(\\S+)");
    final Matcher matcher = pattern.matcher(cellText);
    if (matcher.find())
    {
      return Team.fromShortForm(matcher.group(1));
    }
    throw new IllegalArgumentException("Can't find team short form:" + gameEventTableRow);
  }
}

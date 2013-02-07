package com.kblaney.nhl.parse;

import com.kblaney.nhl.Team;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

final class DocumentToHomeTeamFunction implements DocumentToTeamFunction
{
  @Override
  public Team getTeam(final Document document)
  {
    final String teamShortform = getTeamShortform(document);
    return Team.fromShortForm(teamShortform);
  }

  private String getTeamShortform(final Document document)
  {
    final Elements homeTeamElements = document.select("td:matchesOwn(On Ice$)");
    if (homeTeamElements.isEmpty())
    {
      throw new IllegalArgumentException("Can't find home team element:" + document);
    }
    return parse(homeTeamElements.get(1).text());
  }

  private String parse(final String homeTeamElementText)
  {
    final Pattern pattern = Pattern.compile("^(\\S+) On Ice");
    final Matcher matcher = pattern.matcher(homeTeamElementText);
    if (matcher.find())
    {
      return matcher.group(1);
    }
    throw new IllegalArgumentException("Can't find home team:" + homeTeamElementText);
  }
}

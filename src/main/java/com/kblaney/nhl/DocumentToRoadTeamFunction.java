package com.kblaney.nhl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

public final class DocumentToRoadTeamFunction implements DocumentToTeamFunction
{
  @Override
  public Team getTeam(final Document document)
  {
    final String teamShortform = getTeamShortform(document);
    return Team.fromShortForm(teamShortform);
  }

  private String getTeamShortform(final Document document)
  {
    final Elements roadTeamElements = document.select("td:matchesOwn(On Ice$)");
    if (roadTeamElements.isEmpty())
    {
      throw new IllegalArgumentException("Can't find road team element:" + document);
    }
    return parse(roadTeamElements.first().text());
  }

  private String parse(final String roadTeamElementText)
  {
    final Pattern pattern = Pattern.compile("^(\\S+) On Ice");
    final Matcher matcher = pattern.matcher(roadTeamElementText);
    if (matcher.find())
    {
      return matcher.group(1);
    }
    throw new IllegalArgumentException("Can't find road team:" + roadTeamElementText);
  }
}

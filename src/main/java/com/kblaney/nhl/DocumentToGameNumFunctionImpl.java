package com.kblaney.nhl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DocumentToGameNumFunctionImpl implements DocumentToGameNumFunction
{
  @Override
  public int getGameNum(final Document document)
  {
    final String gameNumElementText = getGameNumElementText(document);
    return parse(gameNumElementText);
  }

  private String getGameNumElementText(final Document document)
  {
    final Elements gameNumElements = document.select("table[id=GameInfo] td:matchesOwn(^(Game|Match/Game))");
    if (gameNumElements.isEmpty())
    {
      throw new IllegalArgumentException("Can't find game num element:" + document);
    }
    return gameNumElements.first().text();
  }

  private int parse(final String gameNumElementText)
  {
    final Pattern pattern = Pattern.compile("Game 0*(\\d+)");
    final Matcher matcher = pattern.matcher(gameNumElementText);
    if (matcher.find())
    {
      return Integer.parseInt(matcher.group(1));
    }
    throw new IllegalArgumentException("Can't find game num:" + gameNumElementText);
  }
}

package com.kblaney.nhl;

public final class GameNumToPlayByPlayUrlFunction implements GameNumToUrlFunction
{
  @Override
  public String getUrl(final Season season, final int gameNum)
  {
    final String gameNumInUrl = String.format("%04d", gameNum);
    return "http://www.nhl.com/scores/htmlreports/" + season.inUrl() + gameNumInUrl + ".HTM";
  }
}

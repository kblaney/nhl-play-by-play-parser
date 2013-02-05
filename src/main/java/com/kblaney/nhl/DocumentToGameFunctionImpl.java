package com.kblaney.nhl;

import org.jsoup.nodes.Document;

public final class DocumentToGameFunctionImpl implements DocumentToGameFunction
{
  private final DocumentToGameNumFunction documentToGameNumFunction = new DocumentToGameNumFunctionImpl();
  private final DocumentToTeamFunction documentToRoadTeamFunction = new DocumentToRoadTeamFunction();
  private final DocumentToTeamFunction documentToHomeTeamFunction = new DocumentToHomeTeamFunction();

  @Override
  public Game getGame(Document document)
  {
    final int gameNum = documentToGameNumFunction.getGameNum(document);
    final Team roadTeam = documentToRoadTeamFunction.getTeam(document);
    final Team homeTeam = documentToHomeTeamFunction.getTeam(document);
    return new Game(gameNum, roadTeam, homeTeam);
  }
}

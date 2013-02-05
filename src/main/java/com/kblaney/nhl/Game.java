package com.kblaney.nhl;

public final class Game
{
  private final int gameNum;
  private final Team homeTeam;
  private final Team roadTeam;

  public Game(final int gameNum, final Team homeTeam, final Team roadTeam)
  {
    this.gameNum = gameNum;
    this.homeTeam = homeTeam;
    this.roadTeam = roadTeam;
  }

  public int getGameNum()
  {
    return gameNum;
  }

  public Team getHomeTeam()
  {
    return homeTeam;
  }

  public Team getRoadTeam()
  {
    return roadTeam;
  }
}

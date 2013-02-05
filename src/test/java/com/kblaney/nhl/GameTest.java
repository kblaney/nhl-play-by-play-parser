package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public final class GameTest
{
  private String gameNum;
  private Team homeTeam;
  private Team roadTeam;
  private Game game;

  @Before
  public void setUp()
  {
    gameNum = "GAME_NUM";
    homeTeam = Team.ANAHEIM;
    roadTeam = Team.VANCOUVER;
    game = new Game(gameNum, homeTeam, roadTeam);
  }

  @Test
  public void getGameNum()
  {
    assertEquals(gameNum, game.getGameNum());
  }

  @Test
  public void getHomeTeam()
  {
    assertEquals(homeTeam, game.getHomeTeam());
  }

  @Test
  public void getRoadTeam()
  {
    assertEquals(roadTeam, game.getRoadTeam());
  }
}

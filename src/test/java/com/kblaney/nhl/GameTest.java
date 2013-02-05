package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public final class GameTest
{
  private int gameNum;
  private Team roadTeam;
  private Team homeTeam;
  private Game game;

  @Before
  public void setUp()
  {
    gameNum = 123;
    roadTeam = Team.VANCOUVER;
    homeTeam = Team.ANAHEIM;
    game = new Game(gameNum, roadTeam, homeTeam);
  }

  @Test
  public void getGameNum()
  {
    assertEquals(gameNum, game.getGameNum());
  }

  @Test
  public void getRoadTeam()
  {
    assertEquals(roadTeam, game.getRoadTeam());
  }

  @Test
  public void getHomeTeam()
  {
    assertEquals(homeTeam, game.getHomeTeam());
  }

  @Test
  public void equals_Null()
  {
    assertFalse(game.equals(null));
  }

  @Test
  public void equals_WrongType()
  {
    assertFalse(game.equals("This string is the wrong type"));
  }

  @Test
  public void equals_DifferentGameNum()
  {
    final int differentGameNum = gameNum + 1;
    final Game unequalGame = new Game(differentGameNum, roadTeam, homeTeam);
    assertFalse(game.equals(unequalGame));
    assertFalse(unequalGame.equals(game));
  }

  @Test
  public void equals_DifferentRoadTeam()
  {
    final Team differentRoadTeam = Team.CALGARY;
    final Game unequalGame = new Game(gameNum, differentRoadTeam, homeTeam);
    assertFalse(game.equals(unequalGame));
    assertFalse(unequalGame.equals(game));
  }

  @Test
  public void equals_DifferentHomeTeam()
  {
    final Team differentHomeTeam = Team.ST_LOUIS;
    final Game unequalGame = new Game(gameNum, roadTeam, differentHomeTeam);
    assertFalse(game.equals(unequalGame));
    assertFalse(unequalGame.equals(game));
  }

  @Test
  public void equals_EqualInstance()
  {
    final Game equalGame = new Game(gameNum, roadTeam, homeTeam);
    assertEquals(game, equalGame);
  }

  @Test
  public void hashCode_EqualInstance()
  {
    final Game equalGame = new Game(gameNum, roadTeam, homeTeam);
    assertEquals(game.hashCode(), equalGame.hashCode());
  }
}

package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.Before;

public final class DocumentToGameFunctionImplTest
{
  private DocumentToGameFunction function;

  @Before
  public void setUp()
  {
    function = new DocumentToGameFunctionImpl();
  }

  @Test
  public void getGame_GameNumThree() throws Exception
  {
    int gameNum = 3;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(new Game(gameNum, Team.CHICAGO, Team.LOS_ANGELES), function.getGame(document));
  }

  @Test
  public void getGame_GameNumEighty() throws Exception
  {
    int gameNum = 80;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(new Game(gameNum, Team.PHILADELPHIA, Team.NEW_YORK_RANGERS), function.getGame(document));
  }

  @Test
  public void getGame_GameNumOneHundredTen() throws Exception
  {
    int gameNum = 110;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(new Game(gameNum, Team.EDMONTON, Team.COLORADO), function.getGame(document));
  }
}

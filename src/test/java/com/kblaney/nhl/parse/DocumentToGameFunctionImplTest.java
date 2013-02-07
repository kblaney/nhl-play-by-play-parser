package com.kblaney.nhl.parse;

import static org.junit.Assert.*;
import com.kblaney.nhl.Documents;
import com.kblaney.nhl.Game;
import com.kblaney.nhl.Team;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

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

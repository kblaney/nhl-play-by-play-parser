package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public class DocumentToRoadTeamFunctionTest
{
  private DocumentToTeamFunction function;

  @Before
  public void setUp()
  {
    function = new DocumentToRoadTeamFunction();
  }

  @Test
  public void getTeam_EmptyDocument()
  {
    try
    {
      function.getTeam(Documents.getEmptyDocument());
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertTrue(e.getMessage().startsWith("Can't find road team element:"));
    }
  }

  @Test
  public void getTeam_TwoTeamElements()
  {
    assertEquals(Team.ANAHEIM, function.getTeam(Jsoup.parseBodyFragment("<table><td>ANA On Ice</td><td>PIT On Ice</td></table>")));
  }

  @Test
  public void getTeam_NoTeamShortForm()
  {
    try
    {
      function.getTeam(Jsoup.parseBodyFragment("<table><td> On Ice</td></table>"));
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertTrue(e.getMessage().startsWith("Can't find road team:"));
    }
  }

  @Test
  public void getGameNum_GameNumOne() throws Exception
  {
    int gameNum = 1;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(Team.PITTSBURGH, function.getTeam(document));
  }

  @Test
  public void getGameNum_GameNumFourteen() throws Exception
  {
    int gameNum = 14;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(Team.PHILADELPHIA, function.getTeam(document));
  }

  @Test
  public void getGameNum_GameNumOneHundred() throws Exception
  {
    int gameNum = 100;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(Team.EDMONTON, function.getTeam(document));
  }
}

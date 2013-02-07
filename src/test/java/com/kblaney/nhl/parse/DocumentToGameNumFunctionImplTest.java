package com.kblaney.nhl.parse;

import static org.junit.Assert.*;
import com.kblaney.nhl.Documents;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public final class DocumentToGameNumFunctionImplTest
{
  private DocumentToGameNumFunction function;

  @Before
  public void setUp()
  {
    function = new DocumentToGameNumFunctionImpl();
  }

  @Test
  public void getGameNum_EmptyDocument()
  {
    try
    {
      function.getGameNum(Jsoup.parseBodyFragment(""));
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertTrue(e.getMessage().startsWith("Can't find game num element:"));
    }
  }

  @Test
  public void getGameNum_TwoGameNumElements()
  {
    assertEquals(1,
          function.getGameNum(Jsoup.parseBodyFragment("<table id=\"GameInfo\"><td>Game 1</td><td>Game 2</td></table>")));
  }

  @Test
  public void getGameNum_NonIntegralGameNum()
  {
    try
    {
      function.getGameNum(Jsoup.parseBodyFragment("<table id=\"GameInfo\"><td>Game XYZ</td></table>"));
      fail();
    }
    catch (final IllegalArgumentException e)
    {
      assertTrue(e.getMessage().startsWith("Can't find game num:"));
    }
  }

  @Test
  public void getGameNum_SingleDigitGameNum() throws Exception
  {
    int gameNum = 1;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(gameNum, function.getGameNum(document));
  }

  @Test
  public void getGameNum_TwoDigitGameNum() throws Exception
  {
    int gameNum = 13;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(gameNum, function.getGameNum(document));
  }

  @Test
  public void getGameNum_ThreeDigitGameNum() throws Exception
  {
    int gameNum = 121;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(gameNum, function.getGameNum(document));
  }

  @Test
  public void getGameNum_GameInMontreal() throws Exception
  {
    int gameNum = 5;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(gameNum, function.getGameNum(document));
  }
}

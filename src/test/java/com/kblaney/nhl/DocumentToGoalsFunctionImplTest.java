package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public final class DocumentToGoalsFunctionImplTest
{
  private DocumentToGoalsFunction function;

  @Before
  public void setUp()
  {
    function = new DocumentToGoalsFunctionImpl();
  }

  @Test
  public void getGoals_GameNumber12() throws Exception
  {
    int gameNum = 12;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(6, function.getGoals(document, gameNum).size());
  }

  @Test
  public void getGoals_GameNumber73() throws Exception
  {
    int gameNum = 73;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(8, function.getGoals(document, gameNum).size());
  }

  @Test
  public void getGoals_GameNumber127() throws Exception
  {
    int gameNum = 127;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(3, function.getGoals(document, gameNum).size());
  }
}

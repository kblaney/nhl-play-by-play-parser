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
  public void getGoals_GameNumberTwelve() throws Exception
  {
    int gameNum = 12;
    final Document document = Documents.getDocumentForGameNum(gameNum);
    assertEquals(6, function.getGoals(document, gameNum).size());
  }
}

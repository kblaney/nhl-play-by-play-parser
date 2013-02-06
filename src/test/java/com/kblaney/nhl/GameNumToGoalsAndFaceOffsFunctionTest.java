package com.kblaney.nhl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public final class GameNumToGoalsAndFaceOffsFunctionTest
{
  private GameNumToDocumentFunction toDocumentFunction;
  private GameNumToEventsFunction function;

  @Before
  public void setUp()
  {
    toDocumentFunction = mock(GameNumToDocumentFunction.class);
    function = new GameNumToGoalsAndFaceOffsFunction(toDocumentFunction);
  }

  @Test
  public void getGameEvents_Game19() throws Exception
  {
    final int gameNum = 19;
    when(toDocumentFunction.getDocument(gameNum)).thenReturn(Documents.getDocumentForGameNum(gameNum));
    final List<GameEvent> goalsAndFaceOffs = function.getGameEvents(gameNum);
    assertEquals(73, goalsAndFaceOffs.size());
  }
}

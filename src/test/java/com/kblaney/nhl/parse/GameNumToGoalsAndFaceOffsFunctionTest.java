package com.kblaney.nhl.parse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.kblaney.nhl.Documents;
import com.kblaney.nhl.GameEvent;
import com.kblaney.nhl.Season;
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
    final Season season = Season.REGULAR_SEASON_2012_2013;
    final int gameNum = 19;
    when(toDocumentFunction.getDocument(season, gameNum)).thenReturn(Documents.getDocumentForGameNum(gameNum));
    final List<GameEvent> goalsAndFaceOffs = function.getGameEvents(season, gameNum);
    assertEquals(73, goalsAndFaceOffs.size());
  }
}

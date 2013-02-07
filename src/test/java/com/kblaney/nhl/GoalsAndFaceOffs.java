package com.kblaney.nhl;

import static org.mockito.Mockito.*;
import java.util.List;

public class GoalsAndFaceOffs
{
  public static List<GameEvent> getFor(final int gameNum) throws Exception
  {
    final Season season = Season.REGULAR_SEASON_2012_2013;
    final GameNumToDocumentFunction toDocumentFunction = mock(GameNumToDocumentFunction.class);
    final GameNumToEventsFunction function = new GameNumToGoalsAndFaceOffsFunction(toDocumentFunction);
    when(toDocumentFunction.getDocument(season, gameNum)).thenReturn(Documents.getDocumentForGameNum(gameNum));
    return function.getGameEvents(season, gameNum);
  }
}

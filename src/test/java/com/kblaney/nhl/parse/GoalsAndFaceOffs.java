package com.kblaney.nhl.parse;

import static org.mockito.Mockito.*;
import com.kblaney.nhl.Documents;
import com.kblaney.nhl.GameEvent;
import com.kblaney.nhl.Season;
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

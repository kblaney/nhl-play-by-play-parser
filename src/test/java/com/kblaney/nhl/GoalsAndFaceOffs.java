package com.kblaney.nhl;

import static org.mockito.Mockito.*;
import java.util.List;

public class GoalsAndFaceOffs
{
  public static List<GameEvent> getFor(final int gameNum) throws Exception
  {
    final GameNumToDocumentFunction toDocumentFunction = mock(GameNumToDocumentFunction.class);
    final GameNumToEventsFunction function = new GameNumToGoalsAndFaceOffsFunction(toDocumentFunction);
    when(toDocumentFunction.getDocument(gameNum)).thenReturn(Documents.getDocumentForGameNum(gameNum));
    return function.getGameEvents(gameNum);
  }
}

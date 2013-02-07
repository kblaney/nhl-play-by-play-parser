package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.List;

public final class GameNumToGoalsAndFaceOffsFunction implements GameNumToEventsFunction
{
  private final GameNumToDocumentFunction toDocumentFunction;
  private final GameEventTableRowParser rowParser = new GameEventTableRowParserImpl();
  private final TableRowToGameEventFunction<Goal> toGoalFunction = new TableRowToGoalFunction();
  private final TableRowToGameEventFunction<FaceOff> toFaceOffFunction = new TableRowToFaceOffFunction();

  public GameNumToGoalsAndFaceOffsFunction()
  {
    this(new GameNumToPlayByPlayDocumentFunction());
  }

  GameNumToGoalsAndFaceOffsFunction(final GameNumToDocumentFunction toDocumentFunction)
  {
    this.toDocumentFunction = toDocumentFunction;
  }

  @Override
  public List<GameEvent> getGameEvents(final Season season, final int gameNum) throws IOException
  {
    final List<GameEvent> gameEvents = Lists.newArrayList();

    final Document document = toDocumentFunction.getDocument(season, gameNum);
    for (final Element row : document.select("tr.evenColor:has(td:eq(7)"))
    {
      final GameEventType eventType = rowParser.getEventType(row);
      if (eventType.equals(GameEventType.GOAL))
      {
        gameEvents.add(toGoalFunction.getGameEvent(row, gameNum));
      }
      else if (eventType.equals(GameEventType.FACE_OFF))
      {
        gameEvents.add(toFaceOffFunction.getGameEvent(row, gameNum));
      }
    }
    return gameEvents;
  }
}

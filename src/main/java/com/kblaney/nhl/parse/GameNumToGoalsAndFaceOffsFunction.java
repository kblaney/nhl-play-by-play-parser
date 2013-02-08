package com.kblaney.nhl.parse;

import com.google.common.collect.Lists;
import com.kblaney.nhl.GameEvent;
import com.kblaney.nhl.GameEventType;
import com.kblaney.nhl.Goal;
import com.kblaney.nhl.Season;
import java.io.IOException;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public final class GameNumToGoalsAndFaceOffsFunction implements GameNumToEventsFunction
{
  private final GameNumToDocumentFunction toDocumentFunction;
  private final GameEventTableRowParser rowParser = new GameEventTableRowParserImpl();
  private final TableRowToGameEventFunction<Goal> toGoalFunction = new TableRowToGoalFunction();
  private final TableRowFaceOffParserImpl faceOffRowParser = new TableRowFaceOffParserImpl();

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
        if (faceOffRowParser.doesFaceOffHaveWinner(row))
        {
          gameEvents.add(faceOffRowParser.getGameEvent(row, gameNum));
        }
      }
    }
    return gameEvents;
  }
}

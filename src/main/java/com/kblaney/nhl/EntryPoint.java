package com.kblaney.nhl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
  {
    final GameNumToDocumentFunction toDocumentFunction = new GameNumToPlayByPlayDocumentFunction();
    final GameEventTableRowParser rowParser = new GameEventTableRowParserImpl();

    int gameNum = 1;
    final int maxGameNum = 137;
    while (gameNum <= maxGameNum)
    {
      final Document document = toDocumentFunction.getDocument(gameNum);
      for (final Element row : document.select("tr.evenColor:has(td:eq(7)"))
      {
        final GameEventType eventType = rowParser.getEventType(row);
        System.out.println("Game " + gameNum + ":" + eventType);
        if (eventType.equals(GameEventType.GOAL))
        {
          final Goal goal = new TableRowToGoalFunction().getGameEvent(row, gameNum);
          System.out.println("GOAL - Period " + goal.getPeriod() + ":" + goal.getNumSecondsIntoPeriod());
        }
        else if (eventType.equals(GameEventType.FACE_OFF))
        {
          final FaceOff faceOff = new TableRowToFaceOffFunction().getGameEvent(row, gameNum);
          System.out.println("FACE OFF - Period " + faceOff.getPeriod() + ":" + faceOff.getNumSecondsIntoPeriod());
        }
      }
      gameNum++;
    }
  }
}

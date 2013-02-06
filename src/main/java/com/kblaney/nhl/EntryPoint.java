package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.PrintStream;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
  {
    final GameNumToDocumentFunction toDocumentFunction = new GameNumToPlayByPlayDocumentFunction();
    final DocumentToGameFunction toGameFunction = new DocumentToGameFunctionImpl();
    int gameNum = 1;
    final int maxGameNum = 136;
    final PrintStream printStream = new PrintStream(new File("C:/data/vancouverCanucks/nhl-stats/games.csv"));
    try
    {
      while (gameNum <= maxGameNum)
      {
        System.out.println(gameNum);
        final Document document = toDocumentFunction.getDocument(gameNum);
        final Game game = toGameFunction.getGame(document);
        final List<String> fields = Lists.newArrayList(Integer.toString(game.getGameNum()), game.getRoadTeam()
              .toString(), game.getHomeTeam().toString());
        printStream.println(StringUtils.join(fields, ','));
        gameNum++;
      }
    }
    finally
    {
      printStream.close();
    }
  }
}

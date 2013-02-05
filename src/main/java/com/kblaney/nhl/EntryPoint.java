package com.kblaney.nhl;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
  {
    int gameNum = 1;
    final int maxGameNum = 127;
    final GameNumToDocumentFunction function = new GameNumToPlayByPlayDocumentFunction();
    while (gameNum <= maxGameNum)
    {
      System.out.println(gameNum);
      final Document document = function.getDocument(gameNum);
      FileUtils.write(new File("C:/git/nhl-play-by-play-parser/src/test/resources/play-by-play-game" + String.format("%04d", gameNum) + ".htm"), document.toString());
      gameNum++;
    }
  }
}

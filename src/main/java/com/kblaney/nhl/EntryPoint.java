package com.kblaney.nhl;

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
      function.getDocument(gameNum);
      gameNum++;
    }
  }
}

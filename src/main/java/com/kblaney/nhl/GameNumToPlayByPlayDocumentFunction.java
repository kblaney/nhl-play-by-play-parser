package com.kblaney.nhl;

import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.nodes.Document;

final class GameNumToPlayByPlayDocumentFunction implements GameNumToDocumentFunction
{
  @Override
  public Document getDocument(final int gameNum) throws IOException
  {
    final String url = new GameNumToPlayByPlayUrlFunction().getUrl(gameNum);
    return Jsoup.connect(url).timeout(0).maxBodySize(0).get();
  }
}

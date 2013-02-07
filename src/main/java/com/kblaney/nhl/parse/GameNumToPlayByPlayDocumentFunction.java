package com.kblaney.nhl.parse;

import com.kblaney.nhl.Season;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

final class GameNumToPlayByPlayDocumentFunction implements GameNumToDocumentFunction
{
  @Override
  public Document getDocument(final Season season, final int gameNum) throws IOException
  {
    final String url = new GameNumToPlayByPlayUrlFunction().getUrl(season, gameNum);
    return Jsoup.connect(url).timeout(0).maxBodySize(0).get();
  }
}

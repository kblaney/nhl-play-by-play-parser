package com.kblaney.nhl;

import java.io.File;
import org.apache.commons.io.Charsets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public final class Documents
{
  public static Document getEmptyDocument()
  {
    return Jsoup.parseBodyFragment("");
  }

  public static Document getDocumentForGameNum(final int gameNum) throws Exception
  {
    final String resource = String.format("/play-by-play-game%04d.htm", gameNum);
    final File file = new File(Documents.class.getResource(resource).toURI());
    return Jsoup.parse(file, Charsets.UTF_8.name());
  }
}

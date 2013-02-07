package com.kblaney.nhl.parse;

import com.kblaney.nhl.Season;
import java.io.IOException;
import org.jsoup.nodes.Document;

interface GameNumToDocumentFunction
{
  Document getDocument(Season season, int gameNum) throws IOException;
}

package com.kblaney.nhl;

import java.io.IOException;
import org.jsoup.nodes.Document;

interface GameNumToDocumentFunction
{
  Document getDocument(int gameNum) throws IOException;
}

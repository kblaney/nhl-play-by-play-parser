package com.kblaney.nhl;

import org.jsoup.nodes.Document;

interface DocumentToGameFunction
{
  Game getGame(Document document);
}

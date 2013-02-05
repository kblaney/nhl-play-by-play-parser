package com.kblaney.nhl;

import org.jsoup.nodes.Document;

interface DocumentToGameNumFunction
{
  int getGameNum(Document document);
}

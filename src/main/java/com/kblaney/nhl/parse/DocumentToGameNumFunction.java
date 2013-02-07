package com.kblaney.nhl.parse;

import org.jsoup.nodes.Document;

interface DocumentToGameNumFunction
{
  int getGameNum(Document document);
}

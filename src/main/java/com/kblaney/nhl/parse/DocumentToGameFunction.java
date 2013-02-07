package com.kblaney.nhl.parse;

import com.kblaney.nhl.Game;
import org.jsoup.nodes.Document;

public interface DocumentToGameFunction
{
  Game getGame(Document document);
}

package com.kblaney.nhl;

import java.util.List;
import org.jsoup.nodes.Document;

public interface DocumentToGoalsFunction
{
  List<Goal> getGoals(Document document, int gameNum);
}

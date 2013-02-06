package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
  {
    final GameNumToDocumentFunction toDocumentFunction = new GameNumToPlayByPlayDocumentFunction();
    final DocumentToGoalsFunction toGoalsFunction = new DocumentToGoalsFunctionImpl();
    int gameNum = 1;
    final int maxGameNum = 3;
    while (gameNum <= maxGameNum)
    {
      final Document document = toDocumentFunction.getDocument(gameNum);
      for (final Goal goal : toGoalsFunction.getGoals(document, gameNum))
      {
        final List<String> fields = Lists.newArrayList(Integer.toString(goal.getGameNum()), goal.getScoringTeam()
              .toString(), Integer.toString(goal.getPeriod()), Integer.toString(goal.getNumSecondsIntoPeriod()));
        System.out.println(StringUtils.join(fields, ','));
      }
      gameNum++;
    }
  }
}

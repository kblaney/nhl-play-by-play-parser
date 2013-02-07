package com.kblaney.nhl;

import java.io.IOException;
import com.google.common.collect.Lists;
import java.util.List;

public final class EntryPoint
{
  public static void main(final String[] args) throws IOException
  {
    final List<GameEvent> goalsAndFaceOffs = getGoalsAndFaceOffs();
    final FaceOffGoalStats stats = getStats(goalsAndFaceOffs);
    printStats(stats);
  }

  private static List<GameEvent> getGoalsAndFaceOffs() throws IOException
  {
    final GameNumToEventsFunction toGoalsAndFaceOffsFunction = new GameNumToGoalsAndFaceOffsFunction();
    final List<GameEvent> goalsAndFaceOffs = Lists.newArrayList();
    int gameNum = 1;
    final int maxGameNum = 137;
    while (gameNum <= maxGameNum)
    {
      goalsAndFaceOffs.addAll(toGoalsAndFaceOffsFunction.getGameEvents(gameNum));
      gameNum++;
    }
    return goalsAndFaceOffs;
  }

  private static FaceOffGoalStats getStats(final List<GameEvent> goalsAndFaceOffs)
  {
    final int numSeconds = 15;
    return new FaceOffGoalStatsWithinNSecondsCalculator(numSeconds).calculate(goalsAndFaceOffs);
  }

  private static void printStats(final FaceOffGoalStats stats)
  {
    System.out.println(stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    System.out.println(stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    System.out.println(stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    System.out.println(stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    System.out.println(stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    System.out.println(stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    System.out.println(stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    System.out.println(stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    System.out.println(stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
  }
}

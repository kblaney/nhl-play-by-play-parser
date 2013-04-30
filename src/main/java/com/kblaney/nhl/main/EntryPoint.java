package com.kblaney.nhl.main;

import com.google.common.collect.Lists;
import com.kblaney.nhl.FaceOffGoalStats;
import com.kblaney.nhl.FaceOffGoalStatsWithinNSecondsCalculator;
import com.kblaney.nhl.FaceOffLocation;
import com.kblaney.nhl.GameEvent;
import com.kblaney.nhl.Season;
import com.kblaney.nhl.parse.GameNumToEventsFunction;
import com.kblaney.nhl.parse.GameNumToGoalsAndFaceOffsFunction;
import java.io.IOException;
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
    final int maxGameNum = 1230;
    while (gameNum <= maxGameNum)
    {
      System.out.println(gameNum);
      goalsAndFaceOffs.addAll(toGoalsAndFaceOffsFunction.getGameEvents(Season.REGULAR_SEASON_2007_2008, gameNum));
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

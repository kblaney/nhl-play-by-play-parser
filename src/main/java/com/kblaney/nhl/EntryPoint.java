package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.util.List;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
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
    final int numSeconds = 60;
    final FaceOffGoalStats stats = new FaceOffGoalStatsWithinNSecondsCalculator(numSeconds)
          .calculate(goalsAndFaceOffs);
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

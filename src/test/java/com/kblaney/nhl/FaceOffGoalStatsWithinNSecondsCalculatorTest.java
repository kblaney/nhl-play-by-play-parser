package com.kblaney.nhl;

import static org.junit.Assert.*;
import com.kblaney.nhl.parse.GoalsAndFaceOffs;
import java.util.List;
import org.junit.Test;

public final class FaceOffGoalStatsWithinNSecondsCalculatorTest
{
  @Test
  public void getGameEvents_Game1WithinOneSeconds() throws Exception
  {
    final int gameNum = 1;
    final List<GameEvent> goalsAndFaceOffs = GoalsAndFaceOffs.getFor(gameNum);
    final int numSeconds = 1;
    final FaceOffGoalStats stats = new FaceOffGoalStatsWithinNSecondsCalculator(numSeconds).calculate(goalsAndFaceOffs);
    assertEquals(21, stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(23, stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(18, stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
  }

  @Test
  public void getGameEvents_Game1WithinTwoSeconds() throws Exception
  {
    final int gameNum = 1;
    final List<GameEvent> goalsAndFaceOffs = GoalsAndFaceOffs.getFor(gameNum);
    final int numSeconds = 2;
    final FaceOffGoalStats stats = new FaceOffGoalStatsWithinNSecondsCalculator(numSeconds).calculate(goalsAndFaceOffs);
    assertEquals(21, stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(23, stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(18, stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
  }

  @Test
  public void getGameEvents_Game1Within23Seconds() throws Exception
  {
    final int gameNum = 1;
    final List<GameEvent> goalsAndFaceOffs = GoalsAndFaceOffs.getFor(gameNum);
    final int numSeconds = 23;
    final FaceOffGoalStats stats = new FaceOffGoalStatsWithinNSecondsCalculator(numSeconds).calculate(goalsAndFaceOffs);
    assertEquals(21, stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(23, stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(18, stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(2, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
  }

  @Test
  public void getGameEvents_Game19Within60Seconds() throws Exception
  {
    final int gameNum = 19;
    final List<GameEvent> goalsAndFaceOffs = GoalsAndFaceOffs.getFor(gameNum);
    final int numSeconds = 60;
    final FaceOffGoalStats stats = new FaceOffGoalStatsWithinNSecondsCalculator(numSeconds).calculate(goalsAndFaceOffs);
    assertEquals(27, stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(16, stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(20, stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(3, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(2, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
  }
}

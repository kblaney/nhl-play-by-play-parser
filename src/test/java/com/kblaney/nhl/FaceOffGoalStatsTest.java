package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public final class FaceOffGoalStatsTest
{
  private FaceOffGoalStats stats;

  @Before
  public void setUp()
  {
    stats = new FaceOffGoalStats();
  }

  @Test
  public void getNumFaceOffs_AfterConstruction()
  {
    for (final FaceOffLocation location : FaceOffLocation.values())
    {
      assertEquals(0, stats.getNumFaceOffs(location));
    }
  }

  @Test
  public void getNumFaceOffsWithWinningTeamGoalAfter_AfterConstruction()
  {
    for (final FaceOffLocation location : FaceOffLocation.values())
    {
      assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(location));
    }
  }

  @Test
  public void getNumFaceOffsWithLosingTeamGoalAfter_AfterConstruction()
  {
    for (final FaceOffLocation location : FaceOffLocation.values())
    {
      assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(location));
    }
  }

  @Test
  public void addFaceOffWithNoGoalAfter_NeutralZone()
  {
    stats.addFaceOffWithNoGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
  }

  @Test
  public void addFaceOffWithNoGoalAfter_OffensiveZone()
  {
    stats.addFaceOffWithNoGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
  }

  @Test
  public void addFaceOffWithNoGoalAfter_DefensiveZone()
  {
    stats.addFaceOffWithNoGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
  }

  @Test
  public void addFaceOffWithWinningTeamGoalAfter_NeutralZone()
  {
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
  }

  @Test
  public void addFaceOffWithWinningTeamGoalAfter_OffensiveZone()
  {
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
  }

  @Test
  public void addFaceOffWithWinningTeamGoalAfter_DefensiveZone()
  {
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
  }

  @Test
  public void addFaceOffWithLosingTeamGoalAfter_NeutralZone()
  {
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
  }

  @Test
  public void addFaceOffWithLosingTeamGoalAfter_OffensiveZone()
  {
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
  }

  @Test
  public void addFaceOffWithLosingTeamGoalAfter_DefensiveZone()
  {
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    assertEquals(1, stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(0, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
  }

  @Test
  public void addEveryTypeOfFaceOff()
  {
    stats.addFaceOffWithNoGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithNoGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithNoGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithNoGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithNoGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithNoGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithWinningTeamGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.NEUTRAL_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.DEFENSIVE_ZONE_FACE_OFF);
    stats.addFaceOffWithLosingTeamGoalAfter(FaceOffs.OFFENSIVE_ZONE_FACE_OFF);

    assertEquals(9, stats.getNumFaceOffs(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));
    assertEquals(6, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.NEUTRAL_ZONE));

    assertEquals(6, stats.getNumFaceOffs(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(3, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));
    assertEquals(2, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.DEFENSIVE_ZONE));

    assertEquals(6, stats.getNumFaceOffs(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(2, stats.getNumFaceOffsWithWinningTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
    assertEquals(1, stats.getNumFaceOffsWithLosingTeamGoalAfter(FaceOffLocation.OFFENSIVE_ZONE));
  }
}

package com.kblaney.nhl;

public final class FaceOffGoalStats
{
  private int numNeutralZoneFaceOffsWithNoGoalAfter;
  private int numNeutralZoneFaceOffsWithWinningTeamGoalAfter;
  private int numNeutralZoneFaceOffsWithLosingTeamGoalAfter;
  private int numOffensiveZoneFaceOffsWithNoGoalAfter;
  private int numOffensiveZoneFaceOffsWithWinningTeamGoalAfter;
  private int numOffensiveZoneFaceOffsWithLosingTeamGoalAfter;
  private int numDefensiveZoneFaceOffsWithNoGoalAfter;
  private int numDefensiveZoneFaceOffsWithWinningTeamGoalAfter;
  private int numDefensiveZoneFaceOffsWithLosingTeamGoalAfter;

  public int getNumFaceOffs(final FaceOffLocation location)
  {
    switch (location)
    {
      case NEUTRAL_ZONE:
      {
        return numNeutralZoneFaceOffsWithNoGoalAfter + numNeutralZoneFaceOffsWithWinningTeamGoalAfter +
              numNeutralZoneFaceOffsWithLosingTeamGoalAfter;
      }
      case OFFENSIVE_ZONE:
      {
        return numOffensiveZoneFaceOffsWithNoGoalAfter + numOffensiveZoneFaceOffsWithWinningTeamGoalAfter +
              numOffensiveZoneFaceOffsWithLosingTeamGoalAfter;
      }
      case DEFENSIVE_ZONE:
      {
        return numDefensiveZoneFaceOffsWithNoGoalAfter + numDefensiveZoneFaceOffsWithWinningTeamGoalAfter +
              numDefensiveZoneFaceOffsWithLosingTeamGoalAfter;
      }
      default:
      {
        throw new IllegalArgumentException("Unknown face off location:" + location);
      }
    }
  }

  public int getNumFaceOffsWithWinningTeamGoalAfter(final FaceOffLocation location)
  {
    switch (location)
    {
      case NEUTRAL_ZONE:
      {
        return numNeutralZoneFaceOffsWithWinningTeamGoalAfter;
      }
      case OFFENSIVE_ZONE:
      {
        return numOffensiveZoneFaceOffsWithWinningTeamGoalAfter;
      }
      case DEFENSIVE_ZONE:
      {
        return numDefensiveZoneFaceOffsWithWinningTeamGoalAfter;
      }
      default:
      {
        throw new IllegalArgumentException("Unknown face off location:" + location);
      }
    }
  }

  public int getNumFaceOffsWithLosingTeamGoalAfter(final FaceOffLocation location)
  {
    switch (location)
    {
      case NEUTRAL_ZONE:
      {
        return numNeutralZoneFaceOffsWithLosingTeamGoalAfter;
      }
      case OFFENSIVE_ZONE:
      {
        return numOffensiveZoneFaceOffsWithLosingTeamGoalAfter;
      }
      case DEFENSIVE_ZONE:
      {
        return numDefensiveZoneFaceOffsWithLosingTeamGoalAfter;
      }
      default:
      {
        throw new IllegalArgumentException("Unknown face off location:" + location);
      }
    }
  }

  public void addFaceOffWithNoGoalAfter(final FaceOff faceOff)
  {
    switch (faceOff.getLocation())
    {
      case NEUTRAL_ZONE:
      {
        numNeutralZoneFaceOffsWithNoGoalAfter++;
        break;
      }
      case OFFENSIVE_ZONE:
      {
        numOffensiveZoneFaceOffsWithNoGoalAfter++;
        break;
      }
      case DEFENSIVE_ZONE:
      {
        numDefensiveZoneFaceOffsWithNoGoalAfter++;
        break;
      }
      default:
      {
        throw new IllegalArgumentException("Unknown face off location:" + faceOff.getLocation());
      }
    }
  }

  public void addFaceOffWithWinningTeamGoalAfter(final FaceOff faceOff)
  {
    switch (faceOff.getLocation())
    {
      case NEUTRAL_ZONE:
      {
        numNeutralZoneFaceOffsWithWinningTeamGoalAfter++;
        break;
      }
      case OFFENSIVE_ZONE:
      {
        numOffensiveZoneFaceOffsWithWinningTeamGoalAfter++;
        break;
      }
      case DEFENSIVE_ZONE:
      {
        numDefensiveZoneFaceOffsWithWinningTeamGoalAfter++;
        break;
      }
      default:
      {
        throw new IllegalArgumentException("Unknown face off location:" + faceOff.getLocation());
      }
    }
  }

  public void addFaceOffWithLosingTeamGoalAfter(final FaceOff faceOff)
  {
    switch (faceOff.getLocation())
    {
      case NEUTRAL_ZONE:
      {
        numNeutralZoneFaceOffsWithLosingTeamGoalAfter++;
        break;
      }
      case OFFENSIVE_ZONE:
      {
        numOffensiveZoneFaceOffsWithLosingTeamGoalAfter++;
        break;
      }
      case DEFENSIVE_ZONE:
      {
        numDefensiveZoneFaceOffsWithLosingTeamGoalAfter++;
        break;
      }
      default:
      {
        throw new IllegalArgumentException("Unknown face off location:" + faceOff.getLocation());
      }
    }
  }
}

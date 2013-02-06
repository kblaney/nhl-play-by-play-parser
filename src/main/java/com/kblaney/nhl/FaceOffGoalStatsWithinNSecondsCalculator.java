package com.kblaney.nhl;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import java.util.List;

public final class FaceOffGoalStatsWithinNSecondsCalculator implements FaceOffGoalStatsCalculator
{
  private final int numSeconds;

  public FaceOffGoalStatsWithinNSecondsCalculator(final int numSeconds)
  {
    this.numSeconds = numSeconds;
  }

  @Override
  public FaceOffGoalStats calculate(final List<GameEvent> goalsAndFaceOffs)
  {
    final FaceOffGoalStats stats = new FaceOffGoalStats();
    final PeekingIterator<GameEvent> gameEventIterator = Iterators.peekingIterator(goalsAndFaceOffs.iterator());
    while (gameEventIterator.hasNext())
    {
      final GameEvent gameEvent = gameEventIterator.next();
      if (gameEvent.getEventType().equals(GameEventType.FACE_OFF))
      {
        if ((gameEventIterator.hasNext()) && (isNextEventAGoalWithinNSeconds(gameEvent, gameEventIterator.peek())))
        {
          final FaceOff faceOff = (FaceOff) gameEvent;
          final Goal goal = (Goal) gameEventIterator.peek();
          if (faceOff.getWinningTeam().equals(goal.getScoringTeam()))
          {
            stats.addFaceOffWithWinningTeamGoalAfter(faceOff);
          }
          else
          {
            stats.addFaceOffWithLosingTeamGoalAfter(faceOff);
          }
        }
        else
        {
          stats.addFaceOffWithNoGoalAfter((FaceOff) gameEvent);
        }
      }
    }
    return stats;
  }

  private boolean isNextEventAGoalWithinNSeconds(final GameEvent firstEvent, final GameEvent nextEvent)
  {
    if (nextEvent.getEventType().equals(GameEventType.GOAL))
    {
      return ((nextEvent.getNumSecondsIntoPeriod() - firstEvent.getNumSecondsIntoPeriod()) <= numSeconds);
    }
    else
    {
      return false;
    }
  }
}

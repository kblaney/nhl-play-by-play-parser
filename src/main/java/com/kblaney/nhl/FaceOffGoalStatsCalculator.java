package com.kblaney.nhl;

import java.util.List;

public interface FaceOffGoalStatsCalculator
{
  FaceOffGoalStats calculate(List<GameEvent> goalsAndFaceOffs);
}

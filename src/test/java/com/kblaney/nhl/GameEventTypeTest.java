package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Test;

public final class GameEventTypeTest
{
  @Test
  public void fromShortForm_PeriodStart()
  {
    assertEquals(GameEventType.PERIOD_START, GameEventType.fromShortForm("PSTR"));
  }

  @Test
  public void fromShortForm_PeriodEnd()
  {
    assertEquals(GameEventType.PERIOD_END, GameEventType.fromShortForm("PEND"));
  }

  @Test
  public void fromShortForm_Faceoff()
  {
    assertEquals(GameEventType.FACE_OFF, GameEventType.fromShortForm("FAC"));
  }

  @Test
  public void fromShortForm_Goal()
  {
    assertEquals(GameEventType.GOAL, GameEventType.fromShortForm("GOAL"));
  }

  @Test
  public void fromShortForm_Penalty()
  {
    assertEquals(GameEventType.PENALTY, GameEventType.fromShortForm("PENL"));
  }

  @Test
  public void fromShortForm_ShotOnGoal()
  {
    assertEquals(GameEventType.SHOT_ON_GOAL, GameEventType.fromShortForm("SHOT"));
  }

  @Test
  public void fromShortForm_MissedShot()
  {
    assertEquals(GameEventType.MISSED_SHOT, GameEventType.fromShortForm("MISS"));
  }

  @Test
  public void fromShortForm_BlockedShot()
  {
    assertEquals(GameEventType.BLOCKED_SHOT, GameEventType.fromShortForm("BLOCK"));
  }

  @Test
  public void fromShortForm_Giveaway()
  {
    assertEquals(GameEventType.GIVEAWAY, GameEventType.fromShortForm("GIVE"));
  }

  @Test
  public void fromShortForm_Hit()
  {
    assertEquals(GameEventType.HIT, GameEventType.fromShortForm("HIT"));
  }

  @Test
  public void fromShortForm_StoppageInPlay()
  {
    assertEquals(GameEventType.STOPPAGE_IN_PLAY, GameEventType.fromShortForm("STOP"));
  }

  @Test
  public void fromShortForm_ShootoutComplete()
  {
    assertEquals(GameEventType.SHOOTOUT_COMPLETE, GameEventType.fromShortForm("SOC"));
  }

  @Test
  public void fromShortForm_GameEnd()
  {
    assertEquals(GameEventType.GAME_END, GameEventType.fromShortForm("GEND"));
  }
}

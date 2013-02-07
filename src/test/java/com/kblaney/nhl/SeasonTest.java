package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Test;

public final class SeasonTest
{
  @Test
  public void inUrl_RegularSeason20122013()
  {
    assertEquals("20122013/PL02", Season.REGULAR_SEASON_2012_2013.inUrl());
  }

  @Test
  public void inUrl_RegularSeason20112012()
  {
    assertEquals("20112012/PL02", Season.REGULAR_SEASON_2011_2012.inUrl());
  }
}

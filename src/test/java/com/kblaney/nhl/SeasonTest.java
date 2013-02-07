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

  @Test
  public void inUrl_RegularSeason20102011()
  {
    assertEquals("20102011/PL02", Season.REGULAR_SEASON_2010_2011.inUrl());
  }

  @Test
  public void inUrl_RegularSeason20092010()
  {
    assertEquals("20092010/PL02", Season.REGULAR_SEASON_2009_2010.inUrl());
  }

  @Test
  public void inUrl_RegularSeason20082009()
  {
    assertEquals("20092010/PL02", Season.REGULAR_SEASON_2009_2010.inUrl());
  }

  @Test
  public void inUrl_RegularSeason20072008()
  {
    assertEquals("20072008/PL02", Season.REGULAR_SEASON_2007_2008.inUrl());
  }
}

package com.kblaney.nhl;

public enum Season
{
  REGULAR_SEASON_2012_2013("20122013/PL02"),
  REGULAR_SEASON_2011_2012("20112012/PL02"),
  REGULAR_SEASON_2010_2011("20102011/PL02"),
  REGULAR_SEASON_2009_2010("20092010/PL02"),
  REGULAR_SEASON_2008_2009("20082009/PL02"),
  REGULAR_SEASON_2007_2008("20072008/PL02");

  private final String inUrl;

  private Season(final String inUrl)
  {
    this.inUrl = inUrl;
  }

  public String inUrl()
  {
    return inUrl;
  }
}

package com.kblaney.nhl;

public enum Team
{
  ANAHEIM("ANA"),
  ATLANTA("ATL"),
  BOSTON("BOS"),
  BUFFALO("BUF"),
  CALGARY("CGY"),
  CAROLINA("CAR"),
  CHICAGO("CHI"),
  COLORADO("COL"),
  COLUMBUS("CBJ"),
  DALLAS("DAL"),
  DETROIT("DET"),
  EDMONTON("EDM"),
  FLORIDA("FLA"),
  LOS_ANGELES("L.A"),
  MINNESOTA("MIN"),
  MONTREAL("MTL"),
  NASHVILLE("NSH"),
  NEW_JERSEY("N.J"),
  NEW_YORK_ISLANDERS("NYI"),
  NEW_YORK_RANGERS("NYR"),
  OTTAWA("OTT"),
  PHILADELPHIA("PHI"),
  PHOENIX("PHX"),
  PITTSBURGH("PIT"),
  SAN_JOSE("S.J"),
  ST_LOUIS("STL"),
  TAMPA_BAY("T.B"),
  TORONTO("TOR"),
  VANCOUVER("VAN"),
  WASHINGTON("WSH"),
  WINNIPEG("WPG");

  private final String shortForm;

  private Team(final String shortForm)
  {
    this.shortForm = shortForm;
  }

  public static Team fromShortForm(final String shortForm)
  {
    for (final Team team : values())
    {
      if (team.shortForm.equals(shortForm))
      {
        return team;
      }
    }
    throw new IllegalArgumentException("Unknown team short form:" + shortForm);
  }

  public String getShortForm()
  {
    return shortForm;
  }
}

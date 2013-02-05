package com.kblaney.nhl;

import static org.junit.Assert.*;
import org.junit.Test;

public class TeamTest
{
  @Test
  public void fromShortForm_Anaheim()
  {
    assertEquals(Team.ANAHEIM, Team.fromShortForm("ANA"));
  }

  @Test
  public void fromShortForm_Boston()
  {
    assertEquals(Team.BOSTON, Team.fromShortForm("BOS"));
  }

  @Test
  public void fromShortForm_Buffalo()
  {
    assertEquals(Team.BUFFALO, Team.fromShortForm("BUF"));
  }

  @Test
  public void fromShortForm_Calgary()
  {
    assertEquals(Team.CALGARY, Team.fromShortForm("CGY"));
  }

  @Test
  public void fromShortForm_Carolina()
  {
    assertEquals(Team.CAROLINA, Team.fromShortForm("CAR"));
  }

  @Test
  public void fromShortForm_Chicago()
  {
    assertEquals(Team.CHICAGO, Team.fromShortForm("CHI"));
  }

  @Test
  public void fromShortForm_Colorado()
  {
    assertEquals(Team.COLORADO, Team.fromShortForm("COL"));
  }

  @Test
  public void fromShortForm_Columbus()
  {
    assertEquals(Team.COLUMBUS, Team.fromShortForm("CBJ"));
  }

  @Test
  public void fromShortForm_Dallas()
  {
    assertEquals(Team.DALLAS, Team.fromShortForm("DAL"));
  }

  @Test
  public void fromShortForm_Detroit()
  {
    assertEquals(Team.DETROIT, Team.fromShortForm("DET"));
  }

  @Test
  public void fromShortForm_Edmonton()
  {
    assertEquals(Team.EDMONTON, Team.fromShortForm("EDM"));
  }

  @Test
  public void fromShortForm_Florida()
  {
    assertEquals(Team.FLORIDA, Team.fromShortForm("FLA"));
  }

  @Test
  public void fromShortForm_LosAngeles()
  {
    assertEquals(Team.LOS_ANGELES, Team.fromShortForm("L.A"));
  }

  @Test
  public void fromShortForm_Minnesota()
  {
    assertEquals(Team.MINNESOTA, Team.fromShortForm("MIN"));
  }

  @Test
  public void fromShortForm_Montreal()
  {
    assertEquals(Team.MONTREAL, Team.fromShortForm("MTL"));
  }

  @Test
  public void fromShortForm_Nashville()
  {
    assertEquals(Team.NASHVILLE, Team.fromShortForm("NSH"));
  }

  @Test
  public void fromShortForm_NewJersy()
  {
    assertEquals(Team.NEW_JERSEY, Team.fromShortForm("N.J"));
  }

  @Test
  public void fromShortForm_NewYorkIslanders()
  {
    assertEquals(Team.NEW_YORK_ISLANDERS, Team.fromShortForm("NYI"));
  }

  @Test
  public void fromShortForm_NewYorkRangers()
  {
    assertEquals(Team.NEW_YORK_RANGERS, Team.fromShortForm("NYR"));
  }

  @Test
  public void fromShortForm_Ottawa()
  {
    assertEquals(Team.OTTAWA, Team.fromShortForm("OTT"));
  }

  @Test
  public void fromShortForm_Philadelphia()
  {
    assertEquals(Team.PHILADELPHIA, Team.fromShortForm("PHI"));
  }

  @Test
  public void fromShortForm_Phoenix()
  {
    assertEquals(Team.PHOENIX, Team.fromShortForm("PHX"));
  }

  @Test
  public void fromShortForm_Pittsburgh()
  {
    assertEquals(Team.PITTSBURGH, Team.fromShortForm("PIT"));
  }

  @Test
  public void fromShortForm_SanJose()
  {
    assertEquals(Team.SAN_JOSE, Team.fromShortForm("S.J"));
  }

  @Test
  public void fromShortForm_StLouis()
  {
    assertEquals(Team.ST_LOUIS, Team.fromShortForm("STL"));
  }

  @Test
  public void fromShortForm_TampaBay()
  {
    assertEquals(Team.TAMPA_BAY, Team.fromShortForm("T.B"));
  }

  @Test
  public void fromShortForm_Toronto()
  {
    assertEquals(Team.TORONTO, Team.fromShortForm("TOR"));
  }

  @Test
  public void fromShortForm_Vancouver()
  {
    assertEquals(Team.VANCOUVER, Team.fromShortForm("VAN"));
  }

  @Test
  public void fromShortForm_Washington()
  {
    assertEquals(Team.WASHINGTON, Team.fromShortForm("WSH"));
  }

  @Test
  public void fromShortForm_Winnipeg()
  {
    assertEquals(Team.WINNIPEG, Team.fromShortForm("WPG"));
  }
}

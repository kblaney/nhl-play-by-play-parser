package com.kblaney.nhl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Game
{
  private final int gameNum;
  private final Team roadTeam;
  private final Team homeTeam;

  public Game(final int gameNum, final Team roadTeam, final Team homeTeam)
  {
    this.gameNum = gameNum;
    this.roadTeam = roadTeam;
    this.homeTeam = homeTeam;
  }

  public int getGameNum()
  {
    return gameNum;
  }

  public Team getRoadTeam()
  {
    return roadTeam;
  }

  public Team getHomeTeam()
  {
    return homeTeam;
  }

  @Override
  public boolean equals(final Object thatObject)
  {
    if (!(thatObject instanceof Game))
    {
      return false;
    }
    final Game that = (Game) thatObject;
    return new EqualsBuilder().append(gameNum, that.gameNum).append(roadTeam, that.roadTeam).append(homeTeam, that.homeTeam).isEquals();
  }

  @Override
  public int hashCode()
  {
    return new HashCodeBuilder().append(gameNum).append(roadTeam).append(homeTeam).toHashCode();
  }
}

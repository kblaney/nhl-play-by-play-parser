package com.kblaney.nhl.parse;

import com.kblaney.nhl.Season;

interface GameNumToUrlFunction
{
  String getUrl(Season season, int gameNum);
}

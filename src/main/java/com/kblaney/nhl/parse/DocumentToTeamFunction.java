package com.kblaney.nhl.parse;

import com.kblaney.nhl.Team;
import org.jsoup.nodes.Document;

interface DocumentToTeamFunction
{
  Team getTeam(Document document);
}

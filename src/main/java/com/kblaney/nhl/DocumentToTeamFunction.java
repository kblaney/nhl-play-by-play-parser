package com.kblaney.nhl;

import org.jsoup.nodes.Document;

interface DocumentToTeamFunction
{
  Team getTeam(Document document);
}

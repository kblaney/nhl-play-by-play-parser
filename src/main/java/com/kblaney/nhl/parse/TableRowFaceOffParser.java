package com.kblaney.nhl.parse;

import org.jsoup.nodes.Element;

interface TableRowFaceOffParser
{
  boolean doesFaceOffHaveWinner(Element faceOffTableRow);
}

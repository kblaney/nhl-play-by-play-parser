package com.kblaney.nhl;

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;

public final class EntryPoint
{
  public static void main(final String[] args) throws Exception
  {
    final GameNumToDocumentFunction toDocumentFunction = new GameNumToPlayByPlayDocumentFunction();
    final DocumentToFaceOffsFunction toFaceOffsFunction = new DocumentToFaceOffsFunctionImpl();
    int gameNum = 1;
    final int maxGameNum = 3;
    while (gameNum <= maxGameNum)
    {
      final Document document = toDocumentFunction.getDocument(gameNum);
      for (final FaceOff faceOff : toFaceOffsFunction.getFaceOffs(document, gameNum))
      {
        final List<String> fields = Lists.newArrayList(Integer.toString(faceOff.getGameNum()),
              Integer.toString(faceOff.getPeriod()), Integer.toString(faceOff.getNumSecondsIntoPeriod()),
              faceOff.getWinningTeam().toString(), faceOff.getLocation().toString());
        System.out.println(StringUtils.join(fields, ','));
      }
      gameNum++;
    }
  }
}

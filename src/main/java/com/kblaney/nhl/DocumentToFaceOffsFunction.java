package com.kblaney.nhl;

import java.util.List;
import org.jsoup.nodes.Document;

public interface DocumentToFaceOffsFunction
{
  List<FaceOff> getFaceOffs(Document document, int gameNum);
}

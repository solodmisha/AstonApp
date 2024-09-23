package importFile;

import java.io.IOException;

public interface ImportStrategyDownloads  {
    void store(String object1, String object2) throws IOException;
}
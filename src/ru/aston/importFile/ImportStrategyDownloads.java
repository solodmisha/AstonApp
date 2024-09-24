package ru.aston.importFile;

import java.io.IOException;
import java.util.List;

public interface ImportStrategyDownloads  {
    List<Object> store(Integer typeClass, Integer arraySize) throws IOException;
}
package ru.aston.importFile;

import java.io.IOException;
import java.util.List;

public interface ImportStrategyDownloads <T> {
    List<T> store(Integer typeClass, Integer arraySize) throws IOException;
}
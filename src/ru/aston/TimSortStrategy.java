package ru.aston;

import java.util.Collections;
import java.util.List;

public class TimSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> items) {
        Collections.sort(items);
    }
}
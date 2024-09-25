package ru.aston.sorting;

import java.util.List;

public interface SortStrategy {
    <T extends Sortable> void sort(List<T> list, int n);
}


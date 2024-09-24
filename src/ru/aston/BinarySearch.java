package ru.aston;

import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<T>> int binarySearch(List<T> sortedList, T key) {
        int low = 0;
        int high = sortedList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            T midVal = sortedList.get(mid);

            int cmp = midVal.compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // найдено
            }
        }
        return -1; // не найдено
    }
}


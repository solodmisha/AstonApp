package ru.aston;

import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<T>> int binarySearch(List<T> sortedList, T key) {
        if (sortedList.isEmpty()) {
            return -1; // В коллекции нет элементов
        }
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int mid = right - (right - left) / 2;
            T midVal = sortedList.get(mid);

            if (midVal.compareTo(key) == 0) {
                return mid;
            }
            if (midVal.compareTo(key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // не найдено
    }
}


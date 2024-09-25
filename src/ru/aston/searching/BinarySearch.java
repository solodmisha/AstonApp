package ru.aston.searching;

import ru.aston.sorting.Sortable;

import java.util.List;
import java.util.Objects;

public class BinarySearch {
    public <T extends Sortable> int binarySearch(List<T> sortedList, Long id) {
        if (sortedList.isEmpty()) {
            return -1; // В коллекции нет элементов
        }
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int mid = right - (right - left) / 2;
            T midVal = sortedList.get(mid);

            if (Objects.equals(midVal.getId(), id)) {
                return mid;
            }
            if (midVal.getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // не найдено
    }
}


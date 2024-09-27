package ru.aston.sorting;

import java.util.List;

import java.util.ArrayList;

public class TimSortStrategy implements SortStrategy {
    private final int MIN_MERGE = 32;

    private int minRunLength(int n) {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // Эта функция сортирует массив из левого индекса  к правому индексу,
    // размер которого не превышает RUN
    private <T extends Sortable> void insertionSort(List<T> list, int left,
                                                    int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = list.get(i);
            int j = i - 1;
            while (j >= left && list.get(j).getId() > temp.getId()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, temp);
        }
    }

    // Функция слияния объединяет отсортированные прогоны
    private <T extends Sortable> void merge(List<T> list, int l,
                                            int m, int r) {
        // исходный массив разбит на две части: на левый и правый
        int len1 = m - l + 1, len2 = r - m;
        List<T> left = new ArrayList<>(len1);
        List<T> right = new ArrayList<>(len2);
        for (int i = 0; i < len1; i++) {
            left.add(list.get(l + i));
        }
        for (int i = 0; i < len2; i++) {
            right.add(list.get(m + 1 + i));
        }

        int i = 0;
        int j = 0;
        int k = l;

        // После сравнения мы объединяем эти два массива
        while (i < len1 && j < len2) {
            if (left.get(i).getId() <= right.get(j).getId()) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы left, если есть
        while (i < len1) {
            list.set(k, left.get(i));
            k++;
            i++;
        }

        // Копируем оставшийся элемент right, если есть
        while (j < len2) {
            list.set(k, right.get(j));
            k++;
            j++;
        }
    }

    public <T extends Sortable> void sort(List<T> list, int n) {
        int minRun = n > MIN_MERGE ? minRunLength(MIN_MERGE) : n; // Установка минимальной длины RUN

        // Сортировка отдельных подмассивов по размеру RUN
        for (int i = 0; i < n; i += minRun) {
            insertionSort(list, i,
                    Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        // Начинаем слияние с размера RUN (или 32)
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n;
                 left += 2 * size) {

                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                        (n - 1));

                if (mid < right)
                    merge(list, left, mid, right);
            }
        }
    }
}

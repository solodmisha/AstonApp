package ru.aston.sorting;

import java.util.ArrayList;
import java.util.List;

public class EvenSortingStrategy implements SortStrategy {

    @Override
    public <T extends Sortable> void sort(List<T> list, int n) {
        List<T> evenIds = new ArrayList<>();

        for (T t : list) {
            if (t.getId() % 2 == 0) { // Объекты с четным id
                evenIds.add(t);
            }
        }

        TimSortStrategy sorting = new TimSortStrategy();
        sorting.sort(evenIds, evenIds.size());

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() % 2 == 0) {
                list.set(i, evenIds.get(index));
                index++;
            }
        }
    }
}

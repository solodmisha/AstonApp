import java.util.List;

public interface SortStrategy {
    <T extends Sorta> void sort(List<T> list, int n);
}


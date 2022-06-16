package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> bp = (o1, o2) -> comparator.compare(o1, o2) > 0;
        return compare(value, bp);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> bp = (o1, o2) -> comparator.compare(o1, o2) < 0;
        return compare(value, bp);
    }

    public static <T> T compare(List<T> value, BiPredicate<T, T> bp) {
        T rsl = value.get(0);
        for (T el : value) {
            if (bp.test(el, rsl)) {
                rsl = el;
            }
        }
        return rsl;
    }
}

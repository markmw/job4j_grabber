package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void whenMaxIsFifteen() {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(10);
        list.add(5);
        list.add(0);
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compareTo;
        assertThat(maxMin.max(list, comparator), is(15));
    }
    @Test
    public void whenMinIsZero() {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(10);
        list.add(5);
        list.add(0);
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compareTo;
        assertThat(maxMin.min(list, comparator), is(0));
    }

    @Test
    public void whenListIsNull() {
        MaxMin maxMin = new MaxMin();
        List<String> list = List.of();
        assertNull(maxMin.max(list, Comparator.naturalOrder()));
    }
}
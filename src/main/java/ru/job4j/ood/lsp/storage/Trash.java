package ru.job4j.ood.lsp.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Trash implements Store {
    private final List<Food> foods = new ArrayList<>();
    private final Predicate<Food> predicate = p -> getPercentLifeExpired(p) >= ProductVariables.EXPIRED;

    @Override
    public boolean add(Food food) {
        boolean check = false;
        if (filter(food)) {
            check = foods.add(food);
        }
        return check;
    }

    @Override
    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    @Override
    public boolean filter(Food food) {
        return predicate.test(food);
    }

    @Override
    public void clear() {
        foods.clear();
    }
}

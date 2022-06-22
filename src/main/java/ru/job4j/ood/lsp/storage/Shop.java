package ru.job4j.ood.lsp.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store {
    private final List<Food> foods = new ArrayList<>();
    private final Predicate<Food> predicate = p -> getPercentLifeExpired(p) >= ProductVariables.FRESH
            && getPercentLifeExpired(p) < ProductVariables.EXPIRED;

    @Override
    public boolean add(Food food) {
        boolean check = false;
        if (filter(food)) {
            if (getPercentLifeExpired(food) > ProductVariables.STALE) {
                double sale = food.getPrice() * (food.getDiscount() / 100);
                food.setPrice(food.getPrice() - sale);
            }
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
}

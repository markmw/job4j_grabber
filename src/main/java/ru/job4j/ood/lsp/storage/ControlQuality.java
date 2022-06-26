package ru.job4j.ood.lsp.storage;

import java.util.List;
import java.util.stream.Collectors;

public class ControlQuality {
    private final List<Store> storages;

    public ControlQuality(List<Store> storages) {
        this.storages = storages;
    }

    public void distribute(Food food) {
        for (Store s : storages) {
            if (s.filter(food)) {
                s.add(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> foods = storages.stream()
                .flatMap(t -> t.getFoods().stream())
                .collect(Collectors.toList());
        storages.forEach(Store::clear);
        foods.forEach(this::distribute);
    }
}

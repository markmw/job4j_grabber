package ru.job4j.ood.lsp.storage;

import java.util.List;

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
}

package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Store {
    default double getPercentLifeExpired(Food food) {
        LocalDateTime createDate = food.getCreateDate();
        LocalDateTime expireDate = food.getExpireDate();
        LocalDateTime now = LocalDateTime.now();
        double storageTime = ChronoUnit.DAYS.between(createDate, expireDate);
        double lifeTime = ChronoUnit.DAYS.between(createDate, now);
        return lifeTime * 100 / storageTime;
    }
    boolean add(Food food);
    List<Food> getFoods();
    boolean filter(Food food);
    void clear();
}

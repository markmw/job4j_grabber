package ru.job4j.ood.lsp.storage;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {
    private final LocalDateTime now = LocalDateTime.now();
    private final Store warehouse = new Warehouse();
    private final Store shop = new Shop();
    private final Store trash = new Trash();
    private final List<Store> storages = new ArrayList<>(List.of(warehouse, shop, trash));
    private final ControlQuality controlQuality = new ControlQuality(storages);

    @Test
    public void whenAddToWarehouse() {
        LocalDateTime createDate = now.minusDays(2);
        LocalDateTime expireDate = now.plusDays(10);
        Food food = new Food("milk", createDate, expireDate, 83, 30);
        controlQuality.distribute(food);
        assertEquals(warehouse.getFoods(), List.of(food));
    }

    @Test
    public void whenAddToShop() {
        LocalDateTime createDate = now.minusDays(10);
        LocalDateTime expireDate = now.plusDays(10);
        Food food = new Food("milk", createDate, expireDate, 83, 0.3);
        controlQuality.distribute(food);
        assertEquals(shop.getFoods(), List.of(food));
    }

    @Test
    public void whenAddToShopWithDiscount() {
        LocalDateTime createDate = now.minusDays(10);
        LocalDateTime expireDate = now.plusDays(2);
        Food food = new Food("milk", createDate, expireDate, 83, 30);
        controlQuality.distribute(food);
        assertEquals(shop.getFoods().get(0).getPrice(), 58.1, 0.001);
    }

    @Test
    public void whenAddToTrash() {
        LocalDateTime createDate = now.minusDays(8);
        Food food = new Food("milk", createDate, now, 83, 30);
        controlQuality.distribute(food);
        assertEquals(trash.getFoods(), List.of(food));
    }

    @Test
    public void whenAddToAllStorage() {
        Food milk = new Food("milk", now.minusDays(2), now.plusDays(10), 92, 30);
        Food bread = new Food("bread", now.minusDays(3), now.plusDays(3), 50, 30);
        Food meat = new Food("meat", now.minusDays(7), now.plusDays(2), 450, 30);
        Food eggs = new Food("eggs", now.minusDays(20), now, 120, 30);
        controlQuality.distribute(milk);
        controlQuality.distribute(bread);
        controlQuality.distribute(meat);
        controlQuality.distribute(eggs);
        assertEquals(warehouse.getFoods(), List.of(milk));
        assertEquals(shop.getFoods(), List.of(bread, meat));
        assertEquals(shop.getFoods().get(1).getPrice(), 315, 0.001);
        assertEquals(trash.getFoods(), List.of(eggs));
    }

    @Test
    public void whenResortFoods() {
        Food milk = new Food("milk", now.minusDays(2), now.plusDays(10), 92, 30);
        Food bread = new Food("bread", now.minusDays(3), now.plusDays(3), 50, 30);
        Food meat = new Food("meat", now.minusDays(7), now.plusDays(2), 450, 30);
        Food eggs = new Food("eggs", now.minusDays(20), now, 120, 30);
        controlQuality.distribute(milk);
        controlQuality.distribute(bread);
        controlQuality.distribute(meat);
        controlQuality.distribute(eggs);
        assertEquals(warehouse.getFoods(), List.of(milk));
        assertEquals(shop.getFoods(), List.of(bread, meat));
        assertEquals(shop.getFoods().get(1).getPrice(), 315, 0.001);
        assertEquals(trash.getFoods(), List.of(eggs));
        milk.setExpireDate(now.plusDays(3));
        bread.setExpireDate(now);
        controlQuality.resort();
        assertEquals(shop.getFoods(), List.of(milk, meat));
        assertEquals(trash.getFoods(), List.of(bread, eggs));
    }
}
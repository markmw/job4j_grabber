package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarPark implements Parking {
    private final List<Car> storage;
    private int carSpace;
    private int wagonSpace;

    public CarPark(int carSpace, int wagonSpace) {
        this.carSpace = carSpace;
        this.wagonSpace = wagonSpace;
        storage = new ArrayList<>(carSpace + wagonSpace);
    }

    @Override
    public boolean isFree(Car car) {
        return false;
    }

    @Override
    public boolean isParked(Car car) {
        return false;
    }
}

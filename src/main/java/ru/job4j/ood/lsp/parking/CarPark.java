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
        boolean result = false;
        if (car.getSize() == AutoCar.CARSPACE && carSpace >= AutoCar.CARSPACE) {
            result = true;
            carSpace--;
        } else if (car.getSize() > AutoCar.CARSPACE && wagonSpace >= AutoCar.CARSPACE) {
            result = true;
            wagonSpace--;
        } else if (car.getSize() > AutoCar.CARSPACE && carSpace >= car.getSize()) {
            result = true;
            carSpace -= car.getSize();
        }
        return result;
    }

    @Override
    public boolean isParked(Car car) {
        boolean result = isFree(car);
        if (result) {
            storage.add(car);
        }
        return result;
    }
}

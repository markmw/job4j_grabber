package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarParkTest {
    @Test
    @Ignore
    public void whenParkedTwoAutoCarsAndTwoBeachWagon() {
        Parking parking = new CarPark(2, 1);
        Car autoCar = new AutoCar();
        Car autoCar2 = new AutoCar();
        Car wagon = new BeachWagon(2);
        Car wagon2 = new BeachWagon(2);
        assertTrue(parking.isParked(autoCar));
        assertTrue(parking.isParked(autoCar2));
        assertTrue(parking.isParked(wagon));
        assertFalse(parking.isParked(wagon2));
    }

    @Test
    @Ignore
    public void whenParkedTwoWagonsAndOneAutoCar() {
        Parking parking = new CarPark(4, 0);
        Car wagon = new BeachWagon(2);
        Car wagon2 = new BeachWagon(2);
        Car autoCar = new AutoCar();
        assertTrue(parking.isParked(wagon));
        assertTrue(parking.isParked(wagon2));
        assertFalse(parking.isParked(autoCar));
    }

    @Test
    @Ignore
    public void whenNotParkingSpace() {
        Parking parking = new CarPark(0, 0);
        Car autoCar = new AutoCar();
        Car wagon = new BeachWagon(2);
        assertFalse(parking.isParked(autoCar));
        assertFalse(parking.isParked(wagon));
    }
}
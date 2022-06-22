package ru.job4j.ood.lsp.parking;

public interface Parking {
    boolean isFree(Car car);
    boolean isParked(Car car);
}

package ru.job4j.ood.lsp.parking;

public class AutoCar implements Car {
    public static final int CARSPACE = 1;

    @Override
    public int getSize() {
        return CARSPACE;
    }
}
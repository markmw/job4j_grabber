package ru.job4j.ood.lsp.parking;

public class BeachWagon implements Car {
    private int size;

    public BeachWagon(int size) {
        if (size <= AutoCar.CARSPACE) {
            throw new IllegalArgumentException("Is not a Wagon!");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}

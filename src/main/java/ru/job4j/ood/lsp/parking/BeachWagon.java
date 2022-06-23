package ru.job4j.ood.lsp.parking;

public class BeachWagon implements Car {
    private int size;

    public BeachWagon(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Is not a Wagon!");
        }
    }

    @Override
    public int getSize() {
        return size;
    }
}

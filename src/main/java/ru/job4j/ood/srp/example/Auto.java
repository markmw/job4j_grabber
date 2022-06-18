package ru.job4j.ood.srp.example;

import java.util.List;

public class Auto implements Transmission<String> {
    @Override
    public List<String> switchType(Character character) {
        return null;
    }

    @Override
    public Boolean switching(boolean make) {
        return null;
    }
}

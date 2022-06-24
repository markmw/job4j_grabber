package ru.job4j.ood.dip;

import java.util.HashMap;

public class Telephone {
    private HashMap<String, String> contacts = new HashMap<>();

    public Telephone(HashMap<String, String> contacts) {
        this.contacts = contacts;
    }
}

/*
   Класс зависит от реализации хранилища контактов.
*/

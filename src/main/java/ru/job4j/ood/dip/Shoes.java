package ru.job4j.ood.dip;

public class Shoes {
    private WomanShoes womanShoes;

    public void msg() {
        this.womanShoes = new WomanShoes();
        womanShoes.fitting();
    }
}

class WomanShoes {
    public void fitting() {
        System.out.println("Suitable size!");
    }
}

/*
   Класс Shoes зависит от класса WomanShoes.
*/



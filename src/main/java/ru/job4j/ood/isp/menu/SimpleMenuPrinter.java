package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    public static final String INDENT = "-";

    @Override
    public void print(Menu menu) {
        menu.forEach(p -> {
            int lengthNumber = p.getNumber().length();
            if (lengthNumber > 2) {
                System.out.println(INDENT.repeat(lengthNumber) + p.getNumber() + p.getName());
            } else {
                System.out.println(p.getNumber() + p.getName());
            }
        });
    }
}

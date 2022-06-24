package ru.job4j.ood.isp.menu;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleMenuTest {
    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertEquals(new Menu.MenuItemInfo(
                        "Сходить в магазин", List.of("Купить продукты"), STUB_ACTION, "1."),
                menu.select("Сходить в магазин").get());
        assertEquals(new Menu.MenuItemInfo(
                        "Купить продукты", List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."),
                menu.select("Купить продукты").get());
        assertEquals(new Menu.MenuItemInfo(
                        "Покормить собаку", List.of(), STUB_ACTION, "2."),
                menu.select("Покормить собаку").get());
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    public void whenSelectNotExisted() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertTrue(menu.select("Сходить в парикмахерскую").isEmpty());
    }

    @Test
    public void whenSelectDeepHided() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить хлеб", "Купить белый хлеб", STUB_ACTION);
        assertEquals(
                new Menu.MenuItemInfo(
                        "Купить белый хлеб", List.of(), STUB_ACTION, "1.1.1.1."
                ),
                menu.select("Купить белый хлеб").get()
        );
    }

    @Test
    public void whenTestOutput() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream prev = System.out;
        PrintStream now = new PrintStream(output);
        System.setOut(now);
        new SimpleMenuPrinter().print(menu);
        System.setOut(prev);
        String expected = String.join(System.lineSeparator(),
                "1.Сходить в магазин",
                "----1.1.Купить продукты",
                "------1.1.1.Купить хлеб",
                "------1.1.2.Купить молоко",
                "2.Покормить собаку" + System.lineSeparator());
        assertEquals(expected, output.toString());
    }
}
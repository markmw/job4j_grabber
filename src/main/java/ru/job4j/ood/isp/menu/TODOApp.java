package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {
    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new SimpleMenuPrinter();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("==============MENU==============" + System.lineSeparator()
                    + "1. Add new list" + System.lineSeparator()
                    + "2. Show all list" + System.lineSeparator()
                    + "3. Exit");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1) {
                System.out.println("Create menu section?" + System.lineSeparator()
                        + "Enter yes or no: ");
                String main = scanner.nextLine();
                String parent = Menu.ROOT;
                if ("no".equals(main)) {
                    System.out.println("Enter parent menu name: ");
                    parent = scanner.nextLine();
                }
                System.out.println("Enter menu name: ");
                String child = scanner.nextLine();
                System.out.println("---Done!---");
                boolean result = menu.add(parent, child, STUB_ACTION);
                if (!result) {
                    throw new IllegalArgumentException("Incorrect parent name!");
                }
            } else if (input == 2) {
                System.out.println("==============");
                menuPrinter.print(menu);
                System.out.println("==============");
            } else if (input == 3) {
                run = false;
            } else {
                System.out.println("Incorrect!");
            }
        }
    }
}

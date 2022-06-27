package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {
    public static final ActionDelegate STUB_ACTION = System.out::println;
    private static final String MENU_ITEMS = """
            1. Add new list
            2. Show all list
            3. Exit
            """;
    private static final int ADD_ACTION = 1;
    private static final int VIEW_ACTION = 2;
    private static final int EXIT_ACTION = 3;
    private static final String ENTER_NO = "no";

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new SimpleMenuPrinter();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(MENU_ITEMS);
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == ADD_ACTION) {
                System.out.println("Create menu section?" + System.lineSeparator()
                        + "Enter yes or no: ");
                String main = scanner.nextLine();
                String parent = Menu.ROOT;
                if (ENTER_NO.equals(main)) {
                    System.out.println("Enter parent menu name: ");
                    parent = scanner.nextLine();
                }
                System.out.println("Enter menu name: ");
                String child = scanner.nextLine();
                System.out.println("---Done!---");
                boolean result = menu.add(parent, child, STUB_ACTION);
                if (!result) {
                    System.out.println("Incorrect parent name! Select again!");
                }
            } else if (input == VIEW_ACTION) {
                System.out.println("==============");
                menuPrinter.print(menu);
                System.out.println("==============");
            } else if (input == EXIT_ACTION) {
                run = false;
            } else {
                System.out.println("Incorrect!");
            }
        }
    }
}

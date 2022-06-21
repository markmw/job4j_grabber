package ru.job4j.ood.lsp;

public class ExampleThree {
    private String username;
    private String password;

    public ExampleThree(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void validate(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Enter correct password!");
        }
    }

    public class OptionalAccount extends ExampleThree {
        public OptionalAccount(String username, String password) {
            super(username, password);
        }

        @Override
        public void validate(String password) {
            System.out.println("Some text");
        }
    }
}

/*
   Инвариант. Отсутствует валидация у пере-определенного метода потомка.
*/

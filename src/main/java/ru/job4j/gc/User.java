package ru.job4j.gc;

public class User {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 0; i < 7800; i++) {
            new User(100, "Ivan100" + i);
        }
        GCDemo.info();
    }
}

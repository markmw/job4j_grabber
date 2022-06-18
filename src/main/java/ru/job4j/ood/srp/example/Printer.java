package ru.job4j.ood.srp.example;

import java.util.List;

public interface Printer<T> {
    List<T> memCached(String papers);
    void print(String msg);
}

/*
 В данном случае нарушается принцип SRP,
 тем что есть принтер, который кроме метода печати,
 так же сохраняет/кэширует в памяти текст.

 Как я понимаю, по-хорошему необходимо создать еще один интерфейс,
 оставив в Printer метод непосдрественно печати, а
 memCached вынести в отдельный интерфейс Memory, т.к. у класса должна быть одна цель.

 */

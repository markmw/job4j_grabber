package ru.job4j.ood.srp.example;

import java.util.List;

public interface Transmission<T> {
    List<T> switchType(Character character);
    Boolean switching(boolean make);
}

/*
  Интерфейс Transmission, тип переключения - switchType,
  действие переключить или нет switching,

  Так же вынести метод switching в отдельный интферфейс, т.к. нарушается одна цель Transmission,
  из-за метода действия которая задает непосредственное переключение этой коробки, Да или Нет.

*/

package ru.job4j.ood.ocp.example;

import java.util.List;

public class ExampleOne {
    private static class Car {
        public String fuel() {
            return "fueling petrol";
        }
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(new Car());
        cars.forEach(Car::fuel);
    }
}

/*
   Необходимо было создать интерфейс Transport и имплементировать его в классе Car,
   так как у нас может появиться класс другого типа транспорта типа Tractor, которое не заправляется бензином.
*/

package ru.job4j.ood.ocp.example;


public class ExampleThree {
    public interface Transport {
        public void fuel();
    }

    private static class Car implements Transport {
        @Override
        public void fuel() {
            System.out.println("Fueling ...");
        }
    }

    private static class Tractor {
        Car car = new Car();

        public void plows(Transport transport) {
            System.out.println("plows");
        }
    }
}

/*
   В этом случае поле не представляет тип абстракции (Transport), а это является нарушением принципа ocp.
*/

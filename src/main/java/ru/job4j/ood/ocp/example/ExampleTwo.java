package ru.job4j.ood.ocp.example;

public class ExampleTwo {
    public interface TV {
        public String playVideo();
    }

    private static class SmartTV implements TV {
        @Override
        public String playVideo() {
            return "Playing video";
        }
    }

    private void playMusic(SmartTV smartTV) {
        System.out.println("Playing music");
    }
}

/*
   В нашем случае метод playMusic принимает параметр не типа абстракции, а это нарушает принцип ocp.
*/

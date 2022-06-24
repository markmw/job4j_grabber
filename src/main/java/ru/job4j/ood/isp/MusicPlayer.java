package ru.job4j.ood.isp;

public interface MusicPlayer {
    void play();
    void stop();
    void next();
    void previous();
    void delete();
}

/*
   Лишний метод удаления, т.к. может появится по мере развития плеера добавление/редактирования итд.
*/
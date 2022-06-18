package ru.job4j.ood.srp.example;

import java.awt.*;

public interface Service {
    Image getImage(String path);
    void saveImage(Image img);
    void sendEmail(String address, String subject, String text);
}

/*
   Три обязанности, работа с изображениями(вернуть и сохранить), и отправка емейла.
   Нарушение SRP, у класса должна быть только одна причина для изменения.

   Для начала в первую очередь вывести метод отправки емейла в отдельный интерфейс.
   Хотя правильнее в идеале все три разделить верно?
*/
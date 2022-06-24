package ru.job4j.ood.isp;

public interface Reader {
    String read();
    String write();
}

/*
   Читалка, лишним методом будет write(), и его лучше вынести в отдельный интерфейс.
*/

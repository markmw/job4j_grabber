package ru.job4j.ood.isp;

public interface Wallet {
    boolean pay();
    String balance();
    boolean topUp();
    void sendStatement();
}

/*
   Интерфейс кошелька, лишний метод sendStatement, т.е. отправка выписки.
   Например, учитывая что отправка выписки может развиться/разбиться на разного формата выписки
   лучше вынести в отдельные интерфейс отправки данных, например Statement.
*/

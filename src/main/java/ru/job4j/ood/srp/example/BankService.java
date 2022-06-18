package ru.job4j.ood.srp.example;

public interface BankService {
    void addUser();
    void blockUser();
    void addAcount();
    void blockAccount();
    void findByRequisite();
    void findByPassport();
    void transferMoney();

}

/*
   Сервис BankService, выглядит избыточно же?
   Т.к. в целом добавление и удаление пользователя и учетки можно вынести в отдельный интерфейс,
   потому что если вдруг понадобится добавление метода удаления, слияния например будет нарушаться
   принцип SRP

*/
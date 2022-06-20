package ru.job4j.ood.srp.example;

import java.util.Objects;

public class Account implements BankService {
    private String username;
    private String passport;
    private String requisite;
    private double balance;

    public Account(String username, String passport, String requisite, double balance) {
        this.username = username;
        this.passport = passport;
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void addUser() {

    }

    @Override
    public void blockUser() {

    }

    @Override
    public void addAcount() {

    }

    @Override
    public void blockAccount() {

    }

    @Override
    public void findByRequisite() {

    }

    @Override
    public void findByPassport() {

    }

    @Override
    public void transferMoney() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(username, account.username) && Objects.equals(passport, account.passport) && Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, passport, requisite, balance);
    }

    @Override
    public String toString() {
        return "Account{"
                + "username='" + username + '\''
                + ", passport='" + passport + '\''
                + ", requisite='" + requisite + '\''
                + ", balance=" + balance
                + '}';
    }
}

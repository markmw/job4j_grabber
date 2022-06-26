package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;

public class Food {
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime expireDate;
    private double price;
    private double discount;

    public Food(String name, LocalDateTime createDate, LocalDateTime expireDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expireDate=" + expireDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }


}

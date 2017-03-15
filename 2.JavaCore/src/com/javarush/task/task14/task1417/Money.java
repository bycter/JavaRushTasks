package com.javarush.task.task14.task1417;

/*
Валюты
Расширить функциональность программы, которая позволит производить манипуляции с валютами.

1. В абстрактном классе Money создай приватное поле amount типа double.
2. Создай публичный геттер для поля amount(public double getAmount()), чтобы к этому полю можно было получить доступ извне класса Money.
3. В отдельном файле создай классы Hrivna, Ruble и USD, которые будут являться потомками класса Money.
4. В классах Hrivna, Ruble и USD реализуй метод getCurrencyName который будет возвращать название соответствующей валюты(строку) в виде аббревиатуры(USD, HRN, RUB).
5. В классах Hrivna, Ruble и USD реал изуй публичный(public) конструктор, который принимает один параметр и вызывает конструктор базового класса(super) с этим параметром.
6. Заполни список allMoney объектами всех возможных, в рамках условия задачи и функциональности программы, валют.
*/

public abstract class Money {
    private double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public abstract String getCurrencyName();
}


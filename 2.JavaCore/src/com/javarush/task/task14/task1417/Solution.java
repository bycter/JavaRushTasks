package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

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

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<>();
            this.allMoney.add(new USD(100));
            this.allMoney.add(new Ruble(20000));
            this.allMoney.add(new Hrivna(50000));

        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}

package com.javarush.task.task14.task1421;

/*
Singleton
Класс является синглтоном (реализует паттерн Singleton), если позволяет создать всего один объект своего типа.

Реализовать Singleton pattern:
1. Создай класс Singleton в отдельном файле.
2. Добавь в него статический метод getInstance().
3. Метод getInstance должен возвращать один и тот же объект класса Singleton при любом вызове метода getInstance.
4. Подумай, каким образом можно запретить создание других объектов этого класса.
5. Сделай все конструкторы в классе Singleton приватными (private).
6. В итоге должна быть возможность создать объект (экземпляр класса) ТОЛЬКО используя метод getInstance.
*/

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

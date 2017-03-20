package com.javarush.task.task15.task1520;

/* 
Тренировка мозга
Найти логическую ошибку: утка(Duck) должна корректно реализовывать интерфейс Movable.
Исправьте ошибку.

Результат вывода в консоль должен быть:
flying
moving
*/

public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements Flyable, Movable {
        @Override
        public void doAction() {
            System.out.println("flying");
        }

        @Override
        public void doAnotherAction() {
            System.out.println("moving");
        }
    }

    public static class Util {
        static void fly(Flyable animal) {
            animal.doAction();
        }

        static void move(Movable animal) {
            animal.doAnotherAction();
        }
    }

    public interface Flyable {
        void doAction();
    }

    public interface Movable {
        void doAnotherAction();
    }
}

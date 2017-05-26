package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить «InterruptedException» при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить «Ура«;
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово «N«, а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()
*/
public class Solution {

    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Infinity());
        threads.add(new InterruptedEx());
        threads.add(new Ura());
        threads.add(new MessageStop());
        threads.add(new ReadNumbers());
    }

    public static void main(String[] args) {

    }

    public static class Infinity extends Thread {

        @Override
        public void run() {

            while (true) {
            }
        }
    }

    public static class InterruptedEx extends Thread {

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Ura extends Thread {

        @Override
        public void run() {

            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class MessageStop extends Thread implements Message {

        @Override
        public void run() {

            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {

            this.interrupt();
        }
    }

    public static class ReadNumbers extends Thread {

        @Override
        public void run() {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            Integer integer = 0;

            while (true) {
                try {
                    if ((s = reader.readLine()).equals("N")) {
                        System.out.println(integer);
                        return;
                    }
                    integer += Integer.parseInt(s);
                } catch (IOException e) {
                }

            }
        }
    }
}
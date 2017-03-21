package com.javarush.task.task15.task1527;

/*
Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) — для чисел (дробные числа разделяются точкой)
alert(String value) — для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        char paramStart = '?';
        char paramSeparator = '&';
        char valueSeparator = '=';

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] urlArray = reader.readLine().toCharArray();

        ArrayList<String> paramList = new ArrayList<>();
        ArrayList<String> valueList = new ArrayList<>();

        String bufferString = "";
        boolean paramFlag = false;
        boolean valueFlag = false;
        boolean endFlag = false;

        for (char c : urlArray) {
            if (c == paramStart) {
                paramFlag = true;
                valueFlag = false;
                continue;
            } else if (c == valueSeparator) {
                endFlag = true;

            } else if (c == paramSeparator || c == '\n') {

                paramFlag = true;
                valueFlag = false;
                continue;
            }

            if (endFlag) {
                if (paramFlag) {
                    paramList.add(bufferString);
                } else if (valueFlag) {
                    valueList.add(bufferString);
                }
                bufferString = "";
                endFlag = false;
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

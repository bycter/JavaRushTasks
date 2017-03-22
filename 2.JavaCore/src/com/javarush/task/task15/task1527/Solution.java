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
http://javarush.ru/alpha/index.html?lvl=15&view&obj=3.14&name=Amigo
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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String[] urlArray = string.split("(&+)|(\\?+)");

        ArrayList<String> paramList = new ArrayList<>();
        ArrayList<String> valueList = new ArrayList<>();

        for (int i = 1; i < urlArray.length; i++) { // начинаем со второго элемента массива
            if (urlArray[i].contains("=")) {
                String[] buffer = urlArray[i].split("=");
                paramList.add(buffer[0]);
                valueList.add(buffer[1]);
            } else {
                paramList.add(urlArray[i]);
                valueList.add("");
            }
        }

        for (String aParamList : paramList) {
            System.out.print(aParamList);
            System.out.print(" ");
        }
        System.out.println("");

        for (int i = 0; i < paramList.size(); i++) {
            if (paramList.get(i).equals("obj")) {
                try {
                    alert(Double.parseDouble(valueList.get(i)));
                } catch (NumberFormatException e) {
                    alert(valueList.get(i));
                }
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

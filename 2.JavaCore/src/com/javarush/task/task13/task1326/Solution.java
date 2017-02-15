package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
11
3
2
10

Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader1.readLine();
//        String fileName = "int.txt";

        reader1.close();

        Scanner reader2 = new Scanner(new FileInputStream(fileName));

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (reader2.hasNext()) {
            Integer number = Integer.parseInt(reader2.nextLine());

            if ((number % 2) == 0) {
                arrayList.add(number);
            }
        }

        reader2.close();

        insertionSort(arrayList);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> array) // сортировка вставками
    {

        int temp; // временная переменная для хранения значения элемента сортируемого массива
        int item; // индекс предыдущего элемента

        for (int counter = 1; counter < array.size(); counter++) {
            temp = array.get(counter); // инициализируем временную переменную текущим значением элемента массива
            item = counter - 1; // запоминаем индекс предыдущего элемента массива
            while (item >= 0 && array.get(item) > temp) // пока индекс не равен 0 и предыдущий элемент массива больше текущего
            {
                array.add(item, temp); // перестановка элементов массива
                array.remove(item + 2);
                item--;
            }
        }
        return array;
    }
}

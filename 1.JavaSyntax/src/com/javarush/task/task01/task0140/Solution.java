package com.javarush.task.task01.task0140;

import java.util.Scanner;

/* 
Выводим квадрат числа
Напиши программу, которая считывает с клавиатуры целое число a и выводит квадрат этого числа (a * a).
Внимательно просмотри лекцию. Для считывания данных с клавиатуры используй метод nextInt() класса Scanner.
*/

public class Solution {

    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);

        int a = scanner1.nextInt();

        System.out.println(a * a);
    }
}
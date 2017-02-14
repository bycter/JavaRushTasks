package com.javarush.task.task13.task1318;

/*
Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (reader1.ready())
        {
            System.out.println(reader1.readLine()); //читаем один байт из потока для чтения
        }

        reader1.close();
        reader.close();
    }
}
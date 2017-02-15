package com.javarush.task.task13.task1319;

/*
Запись в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        while (true) {
            String s = reader.readLine();
            bufferedWriter.write(s);
            if(s.equals("exit")) break;
            bufferedWriter.newLine();

        }

        reader.close();
        bufferedWriter.close();
    }
}

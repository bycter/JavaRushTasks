package com.javarush.task.task13.task1319;

/*
Запись в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        ArrayList<String> arrayList = new ArrayList<>();

        String s = "";
        while (!s.equals("exit")) {
            s = reader.readLine();
            arrayList.add(s);
        }

        FileWriter fw = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fw);
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

        for (String s1 : arrayList) {

            writer.write(s1);
            if (!s1.equals("exit")) {
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }
}

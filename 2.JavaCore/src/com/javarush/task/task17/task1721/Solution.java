package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {

    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static String firstFileName;
    public static String secondFileName;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      firstFileName = reader.readLine();
      secondFileName = reader.readLine();
//        firstFileName = "1.txt";
//        secondFileName = "2.txt";
        reader.close();

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(firstFileName)));
        while (reader1.ready()) {
            allLines.add(reader1.readLine());
        }
        reader1.close();

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(secondFileName)));
        while (reader2.ready()) {
            forRemoveLines.add(reader2.readLine());
        }
        reader2.close();


        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
//        for (String allLine : allLines) {
//            System.out.println(allLine);
//        }
    }

    public void joinData() throws CorruptedDataException {


        for (String removeLine : forRemoveLines) {
            if (!allLines.contains(removeLine)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        for (String removeLine : forRemoveLines) {
            allLines.remove(removeLine);
        }
    }
}

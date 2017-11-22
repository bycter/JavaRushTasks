package com.javarush.task.task17.task1710;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u — обновляет данные человека с данным id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + " " + args[i]);
        }

        switch (args[0]){
            case "-c":
                addInfoPerson();
                break;
            case "-u":
                updateInfoPerson();
                break;
            case "-d":
                deleteInfoPerson();
                break;
            case "-i":
                showInfoPerson();
                break;


        }
    }

    private static void addInfoPerson(){

    }
    private static void updateInfoPerson(){

    }
    private static void deleteInfoPerson(){

    }
    private static void showInfoPerson(){

    }
}

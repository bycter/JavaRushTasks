package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (Person arg : allPeople) {
            System.out.println(arg.toString());
        }

        Person person;
        Date dateOfBirth;

        switch (args[0]) {
            case "-c": // Create Person
                if (args[2] == "м") {
                    allPeople.add(Person.createMale(args[1], dateFormat.parse(args[1])));
                }
                if (args[2] == "ж") {
                    allPeople.add(Person.createFemale(args[1], dateFormat.parse(args[1])));
                }
                System.out.println(allPeople.size());
                break;
            case "-u":
                person = allPeople.get(Integer.parseInt(args[1]));
                if (!person.getName().equals(args[2])){
                    person.setName(args[2]);
                }

                if (args[3] == "м" && !person.getSex().equals(Sex.MALE)) person.setSex(Sex.MALE);
                if (args[3] == "ж" && !person.getSex().equals(Sex.FEMALE)) person.setSex(Sex.FEMALE);

                dateOfBirth =  dateFormat.parse(args[4]);
                if (!person.getBirthDay().equals(dateOfBirth)){
                    person.setBirthDay(dateOfBirth);
                }
                break;
            case "-d":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
                allPeople.add(Integer.parseInt(args[1]), person);
                break;
            case "-i":
                person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.toString());
                break;
            case "-p":
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
                break;
            case "-l":
                for (Person arg : allPeople) {
                    System.out.println(arg.toString());
                }
        }
    }
/*
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u — обновляет данные человека с данным id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке
*/
    private static void updateInfoPerson() {

    }

    private static void deleteInfoPerson() {

    }

    private static void showInfoPerson() {

    }
}

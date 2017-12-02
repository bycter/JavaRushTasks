package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Person person = null;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        if (args[i + 1].equals("м")) {
                            person = Person.createMale(args[i], dateFormat.parse(args[i + 2]));
                        } else if (args[i + 1].equals("ж")) {
                            person = Person.createFemale(args[i], dateFormat.parse(args[i + 2]));

                        }
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {

                        person = allPeople.get(Integer.parseInt(args[i]));

                        if (!person.getName().equals(args[i + 1])) {
                            person.setName(args[i + 1]);
                        }

                        if (args[i + 2].equals("м") && !person.getSex().equals(Sex.MALE)) person.setSex(Sex.MALE);
                        if (args[i + 2].equals("ж") && !person.getSex().equals(Sex.FEMALE))
                            person.setSex(Sex.FEMALE);

                        Date dateOfBirth = dateFormat.parse(args[i + 3]);
                        if (!person.getBirthDay().equals(dateOfBirth)) {
                            person.setBirthDay(dateOfBirth);
                        }
                        allPeople.set(Integer.parseInt(args[i]), person);
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {

                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDay(null);
                        allPeople.set(Integer.parseInt(args[i]), person);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {

                        person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.toString());
                    }
                    break;
                }
        }
    }
}
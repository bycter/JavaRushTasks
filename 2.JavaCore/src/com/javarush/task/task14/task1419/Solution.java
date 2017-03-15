package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений

Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {

    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {

        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        ArrayList arrayList = null;
        try {
            arrayList = new ArrayList(12);
            arrayList.get(1);
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("111.txt"));
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            ArrayList a = null;
            a.add(12);
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try
        {
            String test = "test";
            char test2 = test.charAt(5);
        }
        catch (StringIndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }

        try {
            String a = "test";
            int b = Integer.parseInt(a);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            int[] a = new int[5];
            a[10] = 4;
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Object o = new Float(100);
            Double aDouble = (Double) o;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try
        {
            Solution test = new Solution();
            test.clone();
        }
        catch (CloneNotSupportedException e)
        {
            exceptions.add(e);
        }

        try
        {
            SimpleDateFormat sdf =  new SimpleDateFormat("test");
        }
        catch (IllegalArgumentException e)
        {
            exceptions.add(e);
        }

//        SimpleDateFormat sdf1 =  new SimpleDateFormat("yyyy/dd/mm");
//        try {
//            Date lowDate = sdf1.parse("date");
//        } catch (ParseException e) {
//            exceptions.add(e);
//        }
    }
}

package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.
*/

public class Solution {

    public static Map<Double, String> labels = new HashMap<>();

    static
    {
        labels.put((double) 25, "50");
        labels.put(26.0, "52");
        labels.put(27.0, "54");
        labels.put(28.0, "56");
        labels.put(29.0, "58");
    }
    public static void main(String[] args) {

        System.out.println(labels);
    }
}

package com.javarush.task.task15.task1522;

/*
Закрепляем Singleton pattern
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        try {
            s = reader.readLine();

            if (s.equals(Planet.MOON)) {
                thePlanet = Moon.getInstance();
            } else if (s.equals(Planet.SUN)) {
                thePlanet = Sun.getInstance();
            } else if (s.equals(Planet.EARTH)) {
                thePlanet = Earth.getInstance();
            } else {
                thePlanet = null;
            }

        } catch (IOException e) {
        }
    }
}

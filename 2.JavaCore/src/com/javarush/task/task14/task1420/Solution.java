package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).

Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer a = Integer.parseInt(reader.readLine());
        Integer b = Integer.parseInt(reader.readLine());

        if (a <= 0 || b <= 0) {
            throw new Exception();
        }
        ArrayList<Integer> aDel = new ArrayList<>();
        ArrayList<Integer> bDel = new ArrayList<>();

        dividersOfNumber(a, aDel);
        dividersOfNumber(b, bDel);

        ArrayList<Integer> dividers = new ArrayList<>();
        for (Integer aDiv : aDel) {
            for (Integer bDiv : bDel) {
                if (aDiv.equals(bDiv)){
                    dividers.add(bDiv);
                    break;
                }
            }
        }

        Integer GCD = 1;
        for (Integer divider : dividers) {
            GCD = GCD * divider;
        }
        System.out.println(GCD);
    }

    public static void dividersOfNumber(Integer number, ArrayList<Integer> arrayDividers) {

        arrayDividers.add(1);
        while (number > 1) {
            boolean flag = false;
            for (int i = 2; i < 10000; i++) {
                if ((number % i) == 0) {
                    arrayDividers.add(i);
                    number = number / i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                arrayDividers.add(number);
                break;
            }
        }
    }
}

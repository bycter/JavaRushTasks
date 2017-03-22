package com.javarush.task.task15.task1528;

/* 
ООП - наследование
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        public abstract Object getAmount();
    }

    //add your code below - добавь код ниже
    public static class Hrivna extends Money {
        public double amount = 123d;

        @Override
        public Hrivna getMoney() {
            return this;
        }

        @Override
        public Object getAmount() {
            return this.amount;
        }
    }
}

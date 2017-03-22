package com.javarush.task.task15.task1530;

/*
6. Фразы:
«Берем чашку для латте»
«Заливаем молоком с пенкой»
«Делаем кофе«
*/

public class TeaMaker extends DrinkMaker {


    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    public void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем кипятком");
    }
}

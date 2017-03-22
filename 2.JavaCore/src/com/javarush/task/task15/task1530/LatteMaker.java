package com.javarush.task.task15.task1530;

/*
6. Фразы:
«Заливаем кипятком»
«Берем чашку для латте»
«Насыпаем чай»
«Берем чашку для чая»
«Заливаем молоком с пенкой»
«Делаем кофе«
*/

public class LatteMaker extends DrinkMaker {


    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для латте");
    }

    @Override
    public void putIngredient() {
        System.out.println("Делаем кофе");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем молоком с пенкой");
    }
}

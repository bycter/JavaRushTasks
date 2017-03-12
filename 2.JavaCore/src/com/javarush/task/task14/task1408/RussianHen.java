package com.javarush.task.task14.task1408;

/*
7. В каждом из четырех последних классов написать свою реализацию метода getDescription.

Методы должны возвращать строку вида:
<getDescription() родительского класса> + <» Моя страна — Sssss. Я несу N яиц в месяц.»>
где Sssss — название страны
где N — количество яиц в месяц

8. В классе HenFactory реализовать метод getHen, который возвращает соответствующую стране породу кур.
9. Все созданные вами классы должны быть в отдельных файлах.
*/

public class RussianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {

        return 26;
    }

    @Override
    public String getDescription(){
        return super.getDescription() +
                " Моя страна - " + Country.RUSSIA + ". " +
                "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

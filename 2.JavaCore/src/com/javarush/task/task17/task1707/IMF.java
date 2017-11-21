package com.javarush.task.task17.task1707;
/*
МВФ
Singleton паттерн — синхронизация в методе.
Класс IMF — это Международный Валютный Фонд.
Внутри метода getFund создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте поле imf так, чтобы метод getFund всегда возвращал один и тот же объект.
*/

public class IMF {

    private static IMF imf;

    public static IMF getFund() {
        synchronized (IMF.class){
            if (imf == null) {
                imf = new IMF();
            }
        }
        return imf;
    }

    private IMF() {
    }
}

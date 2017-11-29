package com.javarush.task.task17.task1714;

/* 
Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число, которое показывает что первый пляж лучше(позитивное число)
или второй пляж лучше (негативное число),и насколько он лучше.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    synchronized public String getName() {
        return name;
    }

    synchronized public void setName(String name) {
        this.name = name;
    }

    synchronized public float getDistance() {
        return distance;
    }

    synchronized public void setDistance(float distance) {
        this.distance = distance;
    }

    synchronized public int getQuality() {
        return quality;
    }

    synchronized public void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    @Override
    synchronized public int compareTo(Beach o) {
        int compare = 0;
        if (this.getDistance() < o.getDistance()) compare++;
        if (this.getDistance() > o.getDistance()) compare--;
        if (this.getQuality() > o.getQuality()) compare++;
        if (this.getQuality() < o.getQuality()) compare--;
        return compare;
    }
}

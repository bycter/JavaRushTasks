package com.javarush.task.task14.task1412;

/* 
Реализовать метод printMainInfo
1. Напиши реализацию метода printMainInfo, чтобы:
1.1. Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
1.2. Если в метод передают объект типа Movable, у этого объекта вызывался метод move.
*/

public class Solution {
    public static void main(String[] args) {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object) {

        if (object instanceof Drawable) {
            ((Drawable) object).draw();
        } else if (object instanceof Movable) {
            ((Movable) object).move();
        }
    }

    interface Movable {

        void move();
    }

    static class Circle implements Movable {

        public void draw() {
            System.out.println("can be drawn");
        }

        @Override
        public void move() {
            System.out.println("can be moved");
        }

    }

    interface Drawable {
        void draw();
    }

    static class Rectangle implements Drawable {
        @Override
        public void draw() {
            System.out.println("can be drawn");
        }

        public void move() {
            System.out.println("can be moved");
        }
    }
}

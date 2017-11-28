package com.javarush.task.task17.task1713;

import java.util.*;

/* 
Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
*/

public class Solution implements List {

    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    @Override
    public int size() {
        return original.size();
    }

    @Override
    public boolean isEmpty() {
        return original.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        synchronized (this) {
            return original.contains(o);
        }
    }

    @Override
    public Iterator iterator() {
        synchronized (this) {
            return original.iterator();
        }
    }

    @Override
    public Object[] toArray() {
        synchronized (this) {
            return original.toArray();
        }
    }

    @Override
    public boolean add(Object o) {
        synchronized (this) {
            if (o == null)
                return original.add(null);
            if (o instanceof Long)
                return original.add((Long) o);
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        synchronized (this) {
            return original.remove(o);
        }
    }

    @Override
    public Object[] toArray(Object[] a) {
        synchronized (this) {
            return original.toArray(a);
        }
    }

    @Override
    public boolean addAll(Collection c) {
        synchronized (this) {
            return original.addAll(c);
        }
    }

    @Override
    public boolean addAll(int index, Collection c) {
        synchronized (this) {
            return original.addAll(index, c);
        }
    }

    @Override
    public void clear() {
        synchronized (this) {
            original.clear();
        }
    }

    @Override
    public Object get(int index) {
        synchronized (this) {
            return original.get(index);
        }
    }

    @Override
    public Object set(int index, Object element) {
        synchronized (this) {
            if (element == null)
                return original.set(index, null);
            if (element instanceof Long)
                return original.set(index, (Long) element);
        }
        return false;
    }

    @Override
    synchronized public void add(int index, Object element) {
        if (element == null)
            original.add(index, null);
        if (element instanceof Long)
            original.add(index, (Long) element);
    }

    @Override
    synchronized public Object remove(int index) {
        return null;
    }

    @Override
    synchronized public int indexOf(Object o) {
        return original.indexOf(o);
    }

    @Override
    synchronized public int lastIndexOf(Object o) {

    }

    @Override
    synchronized public ListIterator listIterator() {

    }

    @Override
    synchronized public ListIterator listIterator(int index) {

    }

    @Override
    synchronized public List subList(int fromIndex, int toIndex) {

    }

    @Override
    synchronized public boolean retainAll(Collection c) {

    }

    @Override
    synchronized public boolean removeAll(Collection c) {

    }

    @Override
    synchronized public boolean containsAll(Collection c) {

    }
}

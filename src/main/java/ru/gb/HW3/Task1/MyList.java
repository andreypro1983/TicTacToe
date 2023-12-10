package ru.gb.HW3.Task1;

// Описать собственную коллекцию – список на основе массива.
// Коллекция должна иметь
// возможность хранить любые типы данных,
// иметь методы добавления и удаления элементов.
//Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
//чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.

import java.util.Iterator;

public class MyList<E> implements Iterable<E> {

    Object[] initialArray = {};

    private E[] array;
    private int size;

    public MyList(E[] baseArray) {
        this.array = baseArray;
        size = array.length;
    }

    public MyList() {
        this.array = (E[]) initialArray;
        size = 0;
    }

    public <T extends E> void addElement(T element) {
        if (size == array.length) {
            Object[] newArray;
            if (size == 0) {
                newArray = new Object[array.length + 1];
            } else {
                newArray = new Object[(array.length) * 2];
            }
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[size] = element;
            array = (E[]) newArray;
        } else {
            array[size] = element;
        }
        size++;
    }

    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public int getArrayLength() {
        return array.length;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        StringBuilder result = new StringBuilder("{");
        if (size > 0) {
            for (E element : array) {
                result.append(element).append("; ");
            }
            result.delete(result.length()-2,result.length());
        }
        result.append("}");
        System.out.println(result);

    }

    class MyListIterator implements Iterator<E> {
        int index;

        public MyListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return array[index++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }
}

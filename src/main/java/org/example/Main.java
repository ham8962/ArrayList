package org.example;

import java.util.Arrays;

class ArrayList<E> {

    //private static final int DefaultCapacity = 10;
    //private static final Object[] EmptyArray = {};

    private int size;

    Object[] array;

    /*
    public ArrayList(){
        this.array = EmptyArray;
        this.size = 0; // 원소 개수
    }
    */

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0; // 원소 개수

    }

    //동적할당을 위한 resize 메소드

    public void resize() {
        int arrayCapacity = array.length;

        if (size == arrayCapacity) {
            int newCapacity = arrayCapacity * 2;
            array = Arrays.copyOf(array, newCapacity);
        }

        if (size < (arrayCapacity / 2)) {
            int newCapacity = arrayCapacity / 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    //add 메소드(addLast,add)
    public void addLast(E value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index Setting Error");
        }

        if (size == index) {
            addLast(value);
        } else {

            if (size == array.length) {
                resize();
            }

            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size++;

        }

    }

    //get 메서드
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index Setting Error");
        }
        return (E) array[index];
    }

    //set 메서드

    public void set(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index Setting Error");
        }
        array[index] = value;
    }

    public int indexOf(E value) {
        int i = 0;

        for (i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    //contain 메서드
    public boolean contain(E value) {
        if (indexOf(value) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    // remove 메서드 2개 >> 인덱스 , 객체

    @SuppressWarnings("unchecked")
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index Setting Error");
        }

        E element = (E) array[index];
        array[index] = null;

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }

        size--;
        resize(); // 배열 사이즈는 일정한데 안에 값들이 줄어가니 resize()필요
        return element;
    }

    //remove 메서드
    public boolean remove(E value) {

        int index = indexOf(value);

        if (index == -1) {
            return false;
        }
        remove(index);
        return true;

    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();

    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(3);

        list.addLast("apple");
        list.addLast("banana");
        list.addLast("orange");
        System.out.println(list.size());
        System.out.println(list.get(1));

        list.add(1, "grape");
        System.out.println(list.size());
        System.out.println(list.get(1));

        list.remove("banana");
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
}
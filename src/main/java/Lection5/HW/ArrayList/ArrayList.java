package Lection5.HW.ArrayList;
//Необходимо написать свою реализацию коллекции на выбор LinkedList или ArrayList(можно оба варианта).
// Должны быть основные методы add, get, remove, addAll(ДругаяКоллекция параметр), остальное на ваше усмотрение
//Плюс написать реализацию сортировки пузырьком с флагом, который прекращает сортировку, если коллекция уже отсортирована.
//Задание с *: На тему дженериков.
// Для этих коллекций сделать конструктор который будет принимать другую коллекцию в качестве параметров и инициализироваться с элементами из этой коллекции.
// Вторая часть - сделать метод сортировки статическим, этот метод также будет принимать какую-то коллекцию и сортировать ее.
// (Аналогия Collections.sort()). Т.е подумать на тему какое ключевое слово(extends или super) будет лучше применить для этих двух задач.

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ArrayList <T> {
 Object[] array;
 int indexOfFreeCell = 0;
 int length;

    public ArrayList(T[] array) {
        this.array = array;
        this.length = this.array.length;
        this.indexOfFreeCell = this.length;
    }
    public ArrayList() {
        this.array = new Object[10];
        this.length = this.array.length;
    }

    public ArrayList(Collection<? extends T> collection) {
        this();
        for (T t : collection) {
            add(t);
        }
    }

    public void add(T value) {
        if (array.length <= indexOfFreeCell) {
            increaseArray();
        }
        this.array[indexOfFreeCell] = value;
        indexOfFreeCell++;
    }

    public int get (T object) {
        if (array != null) {
            for (int i = 0; i < indexOfFreeCell; i++) {
                if (array[i].equals(object)) return i;
            }
        }
        return -1;
    }

    public T get (int index) {
        return (T) array[index];
    }

    public boolean remove (T object) {
        int removedObjectIndex = -1;
        for (int i = 0; i < indexOfFreeCell; i++) {
            if (array[i].equals(object)) {
                removedObjectIndex = i;
                break;
            }
        }
        return remove(removedObjectIndex);
    }

    public boolean remove (int index) {
        if (index > 0) {
            for (int i = index; i < indexOfFreeCell; i++) {
                array[i] = array[i+1];
            }
            this.indexOfFreeCell -= 1;
            return true;
        }
        return false;
    }

    public void addCollection (Collection<? extends T> collection) {
        for (T t : collection) {
            add(t);
        }
    }


    private void increaseArray() {
        int newLength = (int) (length * 1.5 + 1);
        Object[] newArray = new Object [newLength];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
        this.length = newLength;
    }

    public static <T> void sortArray(List<T> collection, Comparator<? super T> comparator) {
        for (int i = 0; i < collection.size() - 1; i++) {
            for (int j = 0; j < collection.size() - 1 - i; j++) {
                if (comparator.compare(collection.get(j), collection.get(j + 1)) > 0) {
                    T temp = collection.get(j);
                    collection.set(j, collection.get(j + 1));
                    collection.set(j + 1, temp);
                }
            }
        }
    }


    @Override
    public String toString() {
        return "ArrayList{" +
                "array=" + Arrays.toString(array) +
                ", indexOfFreeCell=" + indexOfFreeCell +
                ", length=" + length +
                '}';
    }
}


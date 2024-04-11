package Lection5.HW.ArrayList;

import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> myArray = new ArrayList<>();
        myArray.add("Hello");
        myArray.add(" ");
        myArray.add("World");
        myArray.add(" !");
        System.out.println(myArray);

        String word = myArray.get(3);
        int index = myArray.get("World");
        System.out.println(word);
        System.out.println(index);

        myArray.remove(1);
        System.out.println(myArray);

        myArray.remove(" !");
        System.out.println(myArray);

        Integer [] array = new Integer [] {0, 1, 2, 3, 4, 5};
        ArrayList<Integer> intArray = new ArrayList<>(array);
        System.out.println(intArray);
        intArray.add(6);
        System.out.println(intArray);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Hello");
        linkedList.add(" ");
        linkedList.add("World");

        ArrayList<String> linkedList2 = new ArrayList<>(linkedList);
        System.out.println(linkedList2);

        LinkedList<Integer> integers= new LinkedList<>();
        integers.add(5);
        integers.add(6);
        integers.add(2);
        integers.add(1);
        integers.add(2);

        LinkedList<Number> numbers= new LinkedList<>();
        numbers.add(3.0);
        numbers.add(4.0);

        ArrayList<Number> numbers2 = new ArrayList<>(numbers);
        System.out.println(numbers2);

        numbers2.addCollection(integers);
        System.out.println(numbers2);

        for (Integer integer : integers) {
            System.out.println(integer.getClass());
        }
        Comparator <Integer> comparing = Comparator.comparing(Integer::intValue);
        ArrayList.sortArray(integers, comparing);
        System.out.println(integers);

    }
}

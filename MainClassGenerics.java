package ru.geek.homeworks.lesson11.generics;

import ru.geek.homeworks.lesson11.generics.fruitsandboxes.Apple;
import ru.geek.homeworks.lesson11.generics.fruitsandboxes.Box;
import ru.geek.homeworks.lesson11.generics.fruitsandboxes.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClassGenerics {

    public static <T> void swapElements (T [] array, int a, int b) {
        T aCopy = array [a];
        T bCopy = array [b];
        array [a] = bCopy;
        array [b] = aCopy;
    }

    public static <T> ArrayList<String> arrayToList (T [] array) {
        ArrayList arrayList = new ArrayList<>(Arrays.asList(array));
        return arrayList;
    }

    public static void main(String[] args) {

        String[] arrayStr = new String[] {"A", "2", "3", "4", "5"};
        swapElements(arrayStr,0, 3);
        System.out.println("Первое задание: " + Arrays.toString(arrayStr));

        Integer[] arrayInt = new Integer[] {1, 2, 3, 4, 5};
        ArrayList<String> arrayList = arrayToList(arrayInt);
        System.out.println("Второе задание: " + arrayList + " - " + arrayList.getClass());
        System.out.println();

        System.out.println("Третье задание (задача): ");
        //создаем экземпляры коробок и фруктов
        Box <Apple> appleBox = new Box();
        Box <Orange> orangeBox = new Box();
        Box <Orange> orangeBox2 = new Box();
        Apple apple = new Apple(1);
        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple(1);
        Orange orange = new Orange(1.5);
        Orange orange1 = new Orange(1.5);
        Orange orange2 = new Orange(1.5);

        //складываем фрукты по коробкам
        appleBox.putInBox(apple);
        appleBox.putInBox(apple1);
        appleBox.putInBox(apple2);
        orangeBox.putInBox(orange);
        orangeBox.putInBox(orange1);
        orangeBox.putInBox(orange2);

        //взвешиваем коробки
        System.out.println("Вес корзины с яблоками - " + appleBox.getWeight() + " у.е.");
        System.out.println("Вес корзины с апельсинами - " + orangeBox.getWeight() + " у.е.");

        //сравниваем коробку яблок и апельсинов
        appleBox.compare(orangeBox);

        //получаем информацию о коробке с апельсинами, пересыпаем фрукты в новую коробку
        orangeBox.getInfo();
        orangeBox.moveTo(orangeBox2);

        orangeBox.getInfo();
        orangeBox2.putInBox(new Orange(1.5));
        orangeBox2.getInfo();

    }

}


/*
Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

Написать метод, который преобразует массив в ArrayList;

Задача:
Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;

Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
Можно сравнивать коробки с яблоками и апельсинами;

Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;

Не забываем про метод добавления фрукта в коробку.

 */
package ru.geek.homeworks.lesson11.generics.fruitsandboxes;

import java.util.ArrayList;

public class Box <T extends Fruit> extends ArrayList {

    //для хранения фруктов нужного класса
    private ArrayList <T> box = new ArrayList<T>();

    //кладем фрукт в коробку
    public void putInBox (T object) {
        box.add(object);
    }

    //вычисляем вес коробки
    public double getWeight() {
        double boxWeight = 0.0;
        for (T object : box){
            boxWeight += object.getFruitWeight();
        }
        return boxWeight;
    }

    //сравниваем разные коробки
    public void compare (Box <?> another) {
        if (Math.abs(this.getWeight() - another.getWeight()) < 0.0001) {
            System.out.println("Массы коробок равны.");
        } else {
            System.out.println("Массы коробок не равны.");
        }
    }

    //пересыпаем фрукты соответствующего типа из одной короки в другую
    public void moveTo (Box <T> another) {
        another.box.addAll(this.box);
        this.box.removeAll(this.box);
    }

    //выводим информацию о коробке
    public void getInfo () {
        try {
            System.out.println("На коробке написано: " + box.get(0) + ". Всего фруктов: " + box.size());
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Кажется, коробка пуста!");
        }
    }

}
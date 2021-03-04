package ru.geek.homeworks.lesson11.generics.fruitsandboxes;

abstract public class Fruit {

    private double weight;

    public Fruit (double weight) {
        this.weight = weight;
    }

    public double getFruitWeight() {
         return weight;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

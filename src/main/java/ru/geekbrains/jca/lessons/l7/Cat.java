package ru.geekbrains.jca.lessons.l7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eatCat(Bowl bowl) {
        satiety = bowl.foodReduce(appetite);
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}

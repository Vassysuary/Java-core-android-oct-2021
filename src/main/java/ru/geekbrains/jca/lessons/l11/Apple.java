package ru.geekbrains.jca.lessons.l11;

public class Apple extends Fruit {

    int number;
    public float weight = 1.0f;

    public Apple(int number) {
        this.number = number;
    }
    public Apple(float weight) {
        super(weight);
    }
    public float getWeight() {
        return weight * number;
    }
}

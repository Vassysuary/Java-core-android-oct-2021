package ru.geekbrains.jca.lessons.l11;

public class Orange extends Fruit {

    int number;
    private float weight = 1.5f;

    public Orange(int number) {
        this.number = number;
    }

    public Orange(float weight) {
        super(weight);
    }

    public float getWeight() {
        return weight * number;
    }
}

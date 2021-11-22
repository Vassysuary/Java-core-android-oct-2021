package ru.geekbrains.jca.lessons.l7;

public class Bowl {
    private int food;

    public void putFoodBowl(int feed) {
        food += feed;
        System.out.printf("The amount of food increased by %d, it became %d in total.\n", feed, food);
    }

    public boolean foodReduce(int amount) {
        if (food - amount < 0) {
            System.out.printf("There is not so much food in a bowl: %d. There are only: %d.\n", amount, food);
            return false;
        } else {
            food -= amount;
            System.out.printf("The food in the bowl has decreased by %d. Remaining: %d.\n", amount, food);
            return true;
        }
    }

    public int getFood() {
        return food;
    }
}

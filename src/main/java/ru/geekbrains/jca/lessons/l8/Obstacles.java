package ru.geekbrains.jca.lessons.l8;

public class Obstacles implements Difficulty{

    private int heightObstacles;

    public Obstacles(int heightObstacles) {
        this.heightObstacles = heightObstacles;
    }

    public int getHeightObstacles() {
        return heightObstacles;
    }

    @Override
    public void Overcoming(Moving moving) {
        if(moving.Jump(heightObstacles)){
            System.out.printf("%s %s overcame the obstacle %d.\n", moving.getClass().getSimpleName(),moving.getName(),heightObstacles);
        } else {
            System.out.printf("%s %s with %d not overcame the obstacle %d.\n", moving.getClass().getSimpleName(), moving.getName(), moving.getMaxJump(), heightObstacles);
            System.out.printf("%s %s leaves the competition.\n", moving.getClass().getSimpleName(), moving.getName());
        }
    }
}

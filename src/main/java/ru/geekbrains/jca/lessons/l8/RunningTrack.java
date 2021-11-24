package ru.geekbrains.jca.lessons.l8;

public class RunningTrack implements Difficulty{

    private int lengthTrack ;

    public RunningTrack(int lengthTrack) {
        this.lengthTrack = lengthTrack;
    }

    public int getLengthTrack() {
        return lengthTrack;
    }

    @Override
    public void Overcoming(Moving moving) {
        if (moving.Run(lengthTrack)) {
            System.out.printf("%s %s ran the distance %d.\n", moving.getClass().getSimpleName(), moving.getName(), lengthTrack);
        } else {
            System.out.printf("%s %s with %d not ran the distance %d.\n", moving.getClass().getSimpleName(), moving.getName(), moving.getMaxRun(), lengthTrack);
            System.out.printf("%s %s leaves the competition.\n", moving.getClass().getSimpleName(), moving.getName());
        }
    }
}

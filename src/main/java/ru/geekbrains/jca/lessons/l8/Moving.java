package ru.geekbrains.jca.lessons.l8;

public interface Moving {
    boolean Run(int length);
    boolean Jump(int height);
    String getName();
    boolean getsuccessFlag();
    int getMaxRun();
    int getMaxJump();
}

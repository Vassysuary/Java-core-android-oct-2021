package ru.geekbrains.jca.lessons.l8;

public class Cat implements Moving{

    private String name;
    private int maxRun;
    private int maxJump;
    private boolean successFlag;

    public Cat(String name, int maxRun, int maxJump, boolean successFlag) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.successFlag = successFlag;
    }

    public boolean isSuccessFlag() {
        return successFlag;
    }

    public String getName() {
        return name;
    }
    public boolean getsuccessFlag() { return successFlag; }
    public int getMaxRun() { return maxRun; }
    public int getMaxJump() { return maxJump; }

    @Override
    public boolean Run(int distance) {
        if (distance > maxRun) {
            successFlag = false;
            return false;
        }
        return true;
    }

    @Override
    public boolean Jump(int height) {
        if (height > maxJump) {
            successFlag = false;
            return false;
        }
        return true;
    }
}

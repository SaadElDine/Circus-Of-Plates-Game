package model;

public class HardLevel implements Strategy {

    @Override
    public int getSpeed() {
        return 3;
    }

    @Override
    public int getTimeout() {
        return 1;
    }

}

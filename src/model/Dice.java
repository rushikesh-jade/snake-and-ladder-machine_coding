package model;

import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int rollDice() {
        return this.random.nextInt(6) + 1;
    }
}

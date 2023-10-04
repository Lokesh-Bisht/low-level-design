package service.impl;

import service.DiceService;

import java.util.Random;

public class DiceServiceImpl implements DiceService {

    private final int maxValue;

    public DiceServiceImpl(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public int roll() {
        return new Random().nextInt(maxValue) + 1;
    }
}

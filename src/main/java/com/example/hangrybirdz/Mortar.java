package com.example.hangrybirdz;

public class Mortar implements IMortar{
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void increment(int input) {
        count += input;
    }

    @Override
    public void decrement(int input) {
        count -= input;
    }


}

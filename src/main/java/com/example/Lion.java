package com.example;

import java.util.List;

public class Lion extends Feline {

    private boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }


    public List<String> getFood() throws Exception {
        return eatMeat();
    }
}
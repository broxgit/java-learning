package com.luv2code.springdemo;

import java.util.Random;

public class ArrayFortuneService implements FortuneService {

    String[] fortunes = {"You will have bad luck", "You will have good luck", "Stop asking me for a fortune"};

    @Override
    public String getFortune() {
        Random rand = new Random();
        return fortunes[rand.nextInt(3)];
    }


}

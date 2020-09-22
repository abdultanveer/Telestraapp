package com.example.telestraapp.overide;

public class Son extends Father {

    @Override
    public void eat() {
        super.eat(); // eats normally
        System.out.println("eats abnormally");
    }
}

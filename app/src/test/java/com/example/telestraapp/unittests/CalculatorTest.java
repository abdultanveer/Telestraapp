package com.example.telestraapp.unittests;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
   public void  add_test(){
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

}
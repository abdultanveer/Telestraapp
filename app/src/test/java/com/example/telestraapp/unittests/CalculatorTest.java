package com.example.telestraapp.unittests;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends TestCase {

    @Test
   public void  add_test(){
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

}
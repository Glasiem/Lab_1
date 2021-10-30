package com.glasiem.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static com.glasiem.app.Evaluate.evaluate;
import static com.glasiem.app.Evaluate.link;
import static org.junit.jupiter.api.Assertions.*;

class EvaluateTest {
    @Test
    public void unitTest1(){
        String test = "inc 7 * 5 ^ 3";
        System.out.println(test);
        test = String.valueOf(evaluate(test));
        String answer = "1000.0";
        System.out.println("Real answer: " + test + " Expected answer: " + answer);
        Assertions.assertEquals(answer, test);
    }
    @Test
    public void unitTest2(){
        Object[][] otherSide = new String[5][5];
        otherSide[2][2] = "#B1";
        otherSide[0][1] = "0";
        HashSet<String> set = new HashSet<>();
        set.add("A1");
        String test = "max(min(max( 1, 3), min(7, 5)), #C3)";
        System.out.println(test);
        try {
            test = link(test, set, otherSide);
            test = String.valueOf(evaluate(test));
            String answer = "3.0";
            System.out.println("Real answer: " + test + " Expected answer: " + answer);
            Assertions.assertEquals(answer, test);
        }
        catch (Exception ex){
            Assertions.assertEquals("1", "0");
        }
    }
    @Test
    public void unitTest3(){
        String test = "5 + a ^ 3";
        System.out.println(test);
        try {
            test = String.valueOf(evaluate(test));
        }
        catch (Exception ex){
            test = "ERROR";
        }
        String answer = "ERROR";
        System.out.println("Real answer: " + test + " Expected answer: " + answer);
        Assertions.assertEquals(answer, test);
    }
}
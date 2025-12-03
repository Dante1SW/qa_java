package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int kittensCount;
    private final int expectedResult;

    public FelineTest(int kittensCount, int expectedResult) {
        this.kittensCount = kittensCount;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, 1},
                {3, 3}
        });
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(3, feline.eatMeat().size());
    }

    @Test
    public void testGetKittensWithoutArgument() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();
        assertEquals(expectedResult, feline.getKittens(kittensCount));
    }
}
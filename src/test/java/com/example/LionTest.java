package com.example;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class LionTest {

    @Test
    public void testConstructorInvalidSex() {
        try {
            new Lion("Invalid");
            fail("Expected exception for invalid sex");
        } catch (Exception e) {

            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец");
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самка");
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }
}
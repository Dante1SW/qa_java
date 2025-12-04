package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testConstructorInvalidSex() {
        try {
            new Lion("Invalid", felineMock);
            fail("Expected exception for invalid sex");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }

    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetKittensVerify() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        lion.getKittens();
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", felineMock);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testGetFoodVerify() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", felineMock);
        lion.getFood();
        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    public void testGetFoodExceptionMessage() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Test exception"));
        Lion lion = new Lion("Самец", felineMock);
        try {
            lion.getFood();
            fail("Expected exception");
        } catch (Exception e) {
            assertEquals("Test exception", e.getMessage());
        }
    }
}
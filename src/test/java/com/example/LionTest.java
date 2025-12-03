package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predatorMock;

    @Mock
    private Feline felineMock;

    @Test
    public void testConstructorInvalidSex() {
        try {
            new Lion("Invalid", predatorMock);
            fail("Expected exception for invalid sex");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("допустимые значения"));
        }
    }

    @Test
    public void testGetKittensWithFeline() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetKittensWithNonFeline() throws Exception {
        Lion lion = new Lion("Самка", predatorMock);
        assertEquals(0, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(predatorMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(3, lion.getFood().size());
    }

    @Test(expected = Exception.class)
    public void testGetFoodException() throws Exception {
        when(predatorMock.eatMeat()).thenThrow(new Exception("Test exception"));
        Lion lion = new Lion("Самка", predatorMock);
        lion.getFood();
    }
}
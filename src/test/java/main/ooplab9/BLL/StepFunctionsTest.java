package main.ooplab9.BLL;

import main.ooplab9.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StepFunctionsTest {

    IStep bll;
    int start = 0;
    int finish = 5;
    int step = 2;
    public static double eps = 1e-5;

    @BeforeEach
    void setUp() {
        bll = new StepFunctions();
    }

    @Test
    void getPointListTest() {
    }

    @Test
    void calcStepsTest(){

        int expected = 2;

        assertEquals(expected, bll.stepsCount(start, finish, step));
    }

    @Test
    void averageTest() {
        List<Point> list = new ArrayList<>(Arrays.asList(
                new Point(0, 0),
                new Point(2.0, -1.68771),
                new Point(4.0, 1.85372)
        ));
        assertEquals(list.get(0).getY(), bll.getPointList(start, finish, step).get(0).getY(), eps);
        assertEquals(list.get(1).getY(), bll.getPointList(start, finish, step).get(1).getY(), eps);
        assertEquals(list.get(2).getY(), bll.getPointList(start, finish, step).get(2).getY(), eps);
    }

    @Test
    void getMaxPointTest() {
    }

    @Test
    void getMinPointTest() {
    }
}
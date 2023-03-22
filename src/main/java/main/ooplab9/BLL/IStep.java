package main.ooplab9.BLL;

import main.ooplab9.Point;

import java.util.List;

public interface IStep {
    public List<Point> getPointList(double start, double finish, double step);
    public double average(List<Point> points);
    public Point getMaxPoint(List<Point> points);
    public Point getMinPoint(List<Point> points);
    public int stepsCount(double start, double finish, double step);
}

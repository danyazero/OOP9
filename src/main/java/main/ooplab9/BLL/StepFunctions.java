package main.ooplab9.BLL;

import main.ooplab9.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StepFunctions implements IStep{

    public List<Point> getPointList(double start, double finish, double step) {
        List<Point> points = new ArrayList<>();
        int n = stepsCount(start, finish, step);

        for (int i=0; i <= n; i++){
            double x = start + i * step;
            double y = f(x);
            points.add(new Point(x ,y));
        }
        return points;
    }

    public int stepsCount(double start, double finish, double step){
        return (int) ((finish - start)/ step);
    }

    public double average(List<Point> points){
        double sum = points.stream().mapToDouble(Point::getY).sum();
        return sum / points.size()+1;
    }

    public Point getMaxPoint(List<Point> points){
        OptionalDouble max = points.stream().mapToDouble(Point::getY).max();
        if (max.isPresent()){
            return points.stream().filter(m -> m.getY() == max.getAsDouble()).findFirst().get();
        }
        return null;
    }

    public Point getMinPoint(List<Point> points){
        OptionalDouble min = points.stream().mapToDouble(Point::getY).min();
        if (min.isPresent()){
            return points.stream().filter(m -> m.getY() == min.getAsDouble()).findFirst().get();
        }
        return null;
    }

    private double f(double x) {
        double y;
        y = (x / (1 + Math.tan(x)));
        return y;
    }

}

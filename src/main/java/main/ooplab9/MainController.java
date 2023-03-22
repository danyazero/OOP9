package main.ooplab9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class HelloController {
    @FXML
    private TextField stepField;
    @FXML
    private TextField finishField;
    @FXML
    private TextField startField;
    @FXML
    private TextArea resultView;

    @FXML
    private void tabulation(){
        double start = Double.parseDouble(startField.getText());
        double finish = Double.parseDouble(finishField.getText());
        double step = Double.parseDouble(stepField.getText());


        List<Point> points = getPointList(start, finish, step);


        show(points, average(points), getMaxPoint(points), getMinPoint(points));
    }

    private List<Point> getPointList(double start, double finish, double step) {
        List<Point> points = new ArrayList<>();
        int n = stepsCount(start, finish, step);

        for (int i=0; i <= n; i++){
            double x = start + i * step;
            double y = f(x);
            points.add(new Point(x ,y));
        }
        return points;
    }

    private int stepsCount(double start, double finish, double step){
        return (int) ((finish - start)/ step);
    }

    private double average(List<Point> points){
        double sum = points.stream().mapToDouble(Point::getY).sum();
        return sum / points.size()+1;
    }

    private Point getMaxPoint(List<Point> points){
        OptionalDouble max = points.stream().mapToDouble(Point::getY).max();
        if (max.isPresent()){
            return points.stream().filter(m -> m.getY() == max.getAsDouble()).findFirst().get();
        }
        return null;
    }

    private Point getMinPoint(List<Point> points){
        OptionalDouble min = points.stream().mapToDouble(Point::getY).min();
        if (min.isPresent()){
            return points.stream().filter(m -> m.getY() == min.getAsDouble()).findFirst().get();
        }
        return null;
    }


    private void show(List<Point> points, double average, Point max, Point min) {
        StringBuilder s = new StringBuilder();
        points.forEach(p -> {
            s.append(p.getX()).append(" ").append(p.getY()).append('\n');
        });

        s.append("Average: ").append(average).append("\n");
        if (max != null) s.append("Max: x = ").append(max.getX()).append(" y = ").append(max.getY()).append("\n");
        if (min != null) s.append("Min: x = ").append(min.getX()).append(" y = ").append(min.getY()).append("\n");

        resultView.setText(s.toString());
    }

    private double f(double x) {
        double y;
        y = (x / (1 + Math.tan(x)));
        return y;
    }
}
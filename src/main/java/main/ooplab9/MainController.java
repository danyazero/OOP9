package main.ooplab9;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.ooplab9.BLL.IStep;
import main.ooplab9.BLL.StepFunctions;

import java.util.List;

public class MainController {
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

        IStep bll = new StepFunctions();
        List<Point> points = bll.getPointList(start, finish, step);

        renderResult(points, bll.average(points), bll.getMaxPoint(points), bll.getMinPoint(points));
    }

    private void renderResult(List<Point> points, double average, Point max, Point min) {
        StringBuilder s = new StringBuilder();

        points.forEach(p -> {
            s.append(p.getX()).append(" ").append(p.getY()).append('\n');
        });

        s.append("Average: ").append(average).append("\n");
        if (max != null) s.append("Max: x = ").append(max.getX()).append(" y = ").append(max.getY()).append("\n");
        if (min != null) s.append("Min: x = ").append(min.getX()).append(" y = ").append(min.getY()).append("\n");

        resultView.setText(s.toString());
    }
}
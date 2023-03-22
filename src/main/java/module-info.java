module main.ooplab9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.ooplab9 to javafx.fxml;
    exports main.ooplab9;
}
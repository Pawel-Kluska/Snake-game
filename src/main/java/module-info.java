module com.pawell.snakegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pawell.snakegame to javafx.fxml;
    exports com.pawell.snakegame;
}
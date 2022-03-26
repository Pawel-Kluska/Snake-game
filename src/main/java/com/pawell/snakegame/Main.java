package com.pawell.snakegame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    final int width = 60, height = 30;
    public final static int block_size = 20;
    final int length = 5;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(5));
        Field field = new Field(width, height);
        root.getChildren().add(field);
        field.addSnake(new Snake(length, field));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Snake game");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
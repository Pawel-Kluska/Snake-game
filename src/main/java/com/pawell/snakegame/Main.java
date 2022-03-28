package com.pawell.snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    final int width = 60, height = 30;
    public final static int block_size = 20;
    final int length = 5;

    long then = System.nanoTime();

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(5));
        Field field = new Field(width, height);
        root.getChildren().add(field);
        field.addSnake(new Snake(length, field));

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(now - then > 50000000) {
                    field.update();
                    then = now;
                }
            }
        };

        animationTimer.start();

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()){
                case UP:
                    if(field.snake.getDirection() != Direction.DOWN)
                    field.snake.setDirection(Direction.UP);
                    break;
                case DOWN:
                    if(field.snake.getDirection() != Direction.UP)
                    field.snake.setDirection(Direction.DOWN);
                    break;
                case LEFT:
                    if(field.snake.getDirection() != Direction.RIGHT)
                    field.snake.setDirection(Direction.LEFT);
                    break;
                case RIGHT:
                    if(field.snake.getDirection() != Direction.LEFT)
                    field.snake.setDirection(Direction.RIGHT);
                    break;
            }
                });

        stage.setScene(scene);
        stage.setTitle("Snake game");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
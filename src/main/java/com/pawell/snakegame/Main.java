package com.pawell.snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    final int width = 60, height = 30;
    public final static int block_size = 20;
    final int length = 5;
    boolean changed = false;

    Field field;

    Direction nextUpdate;
    boolean hasNext = false;

    long then = System.nanoTime();

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(5));
        field = new Field(width, height);
        root.getChildren().add(field);
        field.addSnake(new Snake(length, field));

        Label score = new Label("Score: 0");
        score.setFont(new Font("tahoma", 32));
        root.getChildren().add(score);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(now - then > 50000000) {
                    field.update();
                    then = now;
                    score.setText("Score: " + field.score);
                    changed = false;
                    if(hasNext){
                        setDirection(field.snake, nextUpdate);
                        hasNext = false;
                    }

                    if(field.isDead()){
                        stop();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("You Lost");
                        alert.setContentText("Your Score: " + field.score);
                        Platform.runLater(alert::showAndWait);

                        alert.setOnHidden(e ->{
                            root.getChildren().clear();
                            field = new Field(width, height);
                            field.addSnake(new Snake(length, field));
                            score.setText("Score: 0");
                            root.getChildren().addAll(field, score);
                            start();
                        });

                    }
                }
            }
        };

        animationTimer.start();

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()){
                case UP:
                    if(field.snake.getDirection() != Direction.DOWN)
                    setDirection(field.snake, Direction.UP);
                    break;
                case DOWN:
                    if(field.snake.getDirection() != Direction.UP)
                    setDirection(field.snake, Direction.DOWN);
                    break;
                case LEFT:
                    if(field.snake.getDirection() != Direction.RIGHT)
                    setDirection(field.snake, Direction.LEFT);
                    break;
                case RIGHT:
                    if(field.snake.getDirection() != Direction.LEFT)
                    setDirection(field.snake, Direction.RIGHT);
                    break;
            }
                });

        stage.setScene(scene);
        stage.setTitle("Snake game");
        stage.setResizable(false);
        stage.show();
    }

    public void setDirection(Snake s, Direction d){
        if(!changed){
            s.setDirection(d);
            changed = true;
        }
        else{
            hasNext = true;
            nextUpdate = d;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
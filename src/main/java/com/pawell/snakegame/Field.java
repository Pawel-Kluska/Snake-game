package com.pawell.snakegame;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Field extends Pane {
    private final int width;
    private final int height;
    Snake snake;


    public Field(int width, int height){
        this.width = width;
        this.height = height;

        setMinSize(width * Main.block_size, height * Main.block_size);
        setBackground(new Background(new BackgroundFill(
                Color.WHITE, null, null)));
        setBorder(
                new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                null, new BorderWidths(5))));
    }

    public void update(){
        for(Block block: snake.blocks){
            block.update();
        }
    }

    public void addSnake(Snake snake){
        this.snake = snake;
        for(Block block : snake.blocks){
            addBlock(block);
        }
    }

    public void addBlock(Block block){
        getChildren().add(block);
    }

    public int getWid() {
        return width;
    }

    public int getHei() {
        return height;
    }
}

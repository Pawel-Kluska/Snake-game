package com.pawell.snakegame;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Field extends Pane {
    private int width, height;
    Snake snake;
    ArrayList<Block> blocks = new ArrayList<>();


    public Field(int width, int height){
        this.width = width;
        this.height = height;

        setMinSize(width*Main.block_size, height*Main.block_size);
        setBackground(new Background(new BackgroundFill(
                Color.WHITE, null, null)));
        setBorder(
                new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                null, new BorderWidths(1))));
    }

    public void addSnake(Snake snake){
        this.snake = snake;
        addBlock(snake.head);
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

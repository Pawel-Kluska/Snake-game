package com.pawell.snakegame;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Field extends Pane {
    private final int width;
    private final int height;
    Snake snake;

    int score = 0;
    Food f;

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

        addFood();
    }

    public void update(){
        for(Block block: snake.blocks){
            block.update();
        }

        if(isEatenFood(f)){
            score += 10;
            addFood();
            addNewBlock();
        }
    }

    public boolean isDead(){
        for(Block b : snake.blocks){
            if(b != snake.head){
                if(b.posX == snake.head.posX && b.posY == snake.head.posY)
                    return true;
            }
        }
        return false;
    }

    public void addNewBlock(){
        Block b = new Block(snake.tail.oldPosX, snake.tail.oldPosY, snake.tail, this);
        snake.tail = b;
        snake.blocks.add(b);
        addBlock(b);
    }

    public void addSnake(Snake snake){
        this.snake = snake;
        for(Block block : snake.blocks){
            addBlock(block);
        }
    }

    public void addFood(){
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        Food food = new Food(x, y);
        getChildren().add(food);
        getChildren().remove(f);
        f = food;
    }

    public boolean isEatenFood(Food f){
        return snake.head.posX == f.posX && snake.head.posY == f.posY;
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

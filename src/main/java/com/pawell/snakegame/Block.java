package com.pawell.snakegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.pawell.snakegame.Direction.LEFT;

public class Block extends Rectangle {
    int posX, posY;
    int oldPosX, oldPosY;
    int maxX, maxY;
    Block previous;
    Direction direction = LEFT;

    public Block(int posX, int posY, Block previous, Field field){
        super(Main.block_size, Main.block_size);
        this.posX = posX;
        this.posY = posY;
        this.previous = previous;
        maxX = field.getWid();
        maxY = field.getHei();

        setTranslateX(this.posX * Main.block_size);
        setTranslateY(this.posY * Main.block_size);
        setFill(Color.YELLOW);
        setStroke(Color.GREEN);
        setStrokeWidth(5);

    }


    public void update(){
        oldPosX = posX;
        oldPosY = posY;

        if(previous == null){
            switch (direction){
                case UP:
                    moveUp();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case RIGHT:
                    moveRight();
                    break;
            }
        }
        else{
            posX = previous.oldPosX;
            posY = previous.oldPosY;
        }
        updatePosition();
    }

    public void moveUp(){
        posY--;
        if(posY < 0)
            posY = maxY - 1;
    }

    public void moveDown(){
        posY++;
        if(posY >= maxY)
            posY = 0;
    }

    public void moveLeft(){
        posX--;
        if(posX < 0)
            posX = maxX - 1;
    }

    public void moveRight(){
        posX++;
        if(posX >= maxX)
            posX = 0;
    }

    public void updatePosition(){
        setTranslateX(posX * Main.block_size);
        setTranslateY(posY * Main.block_size);
    }

}

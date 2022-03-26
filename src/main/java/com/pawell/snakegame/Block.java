package com.pawell.snakegame;

import javafx.scene.shape.Circle;

public class Block extends Circle {
    int posX, posY;
    int oldPosX, oldPosY;

    Block previous;

    public Block(int posX, int posY, Block previous){
        super(Main.block_size/2);
        this.posX = posX;
        this.posY = posY;
        this.previous = previous;

        setTranslateX(this.posX * Main.block_size);
        setTranslateY(this.posY * Main.block_size);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}

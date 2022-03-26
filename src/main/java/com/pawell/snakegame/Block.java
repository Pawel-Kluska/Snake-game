package com.pawell.snakegame;

import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    int posX, posY;
    int oldPosX, oldPosY;

    Block previous;

    public Block(int posX, int posY, Block previous){
        super(Main.block_size, Main.block_size);
        this.posX = posX;
        this.posY = posY;
        this.previous = previous;

        setTranslateX(this.posX * Main.block_size);
        setTranslateY(this.posY * Main.block_size);
    }
}

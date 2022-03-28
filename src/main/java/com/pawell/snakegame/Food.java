package com.pawell.snakegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Food extends Rectangle {
    int posX, posY;

    public Food(int posX, int posY){
        super(Main.block_size, Main.block_size);
        this.posX = posX;
        this.posY = posY;

        setTranslateX(this.posX * Main.block_size);
        setTranslateY(this.posY * Main.block_size);
        setFill(Color.RED);

    }

}

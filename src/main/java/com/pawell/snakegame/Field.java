package com.pawell.snakegame;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Field extends Pane {
    private int width, height;

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

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
}

package com.pawell.snakegame;

import java.util.ArrayList;

public class Snake {
    ArrayList<Block> blocks = new ArrayList<>();
    Block head;

    public Snake(int length, Field field){
        int ipx = field.getWid() / 2;
        int ipy = field.getHei() / 2;

        head = new Block(ipx, ipy, null);
        Block previous = head;

        for(int i=1; i<length; i++){
            Block b = new Block(ipx+i, ipy, previous);
            previous = b;
            blocks.add(b);

        }
    }
}

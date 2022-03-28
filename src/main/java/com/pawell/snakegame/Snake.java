package com.pawell.snakegame;

import java.util.ArrayList;

public class Snake {
    ArrayList<Block> blocks = new ArrayList<>();
    Block head;
    Block tail;

    public Snake(int length, Field field){
        int ipx = field.getWid() / 2;
        int ipy = field.getHei() / 2;

        head = new Block(ipx, ipy, null, field);
        blocks.add(head);
        tail = head;

        for(int i=1; i<length; i++){
            Block b = new Block(ipx+i, ipy, tail, field);
            tail = b;
            blocks.add(b);

        }
    }

    public Direction getDirection(){
        return head.direction;
    }

    public void setDirection(Direction d){
        head.direction = d;
    }
}

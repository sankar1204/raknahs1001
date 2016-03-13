package com.example.shanx.bouncingball;

/**
 * Created by Shanx on 3/10/2016.
 */
public class Bubble{
    int Id;
    int x, y;
    int radius;
    InnerSquare internalSquare;

    public Bubble(int x, int y, int r){
        this.x = x;
        this.y = y;
        radius = r;
        internalSquare = new InnerSquare(this.x, this.y, this.radius);
    }
    public Bubble(int x, int y, int r, int i){
        this.x = x;
        this.y = y;
        radius = r;
        this.Id = i;
        internalSquare = new InnerSquare(this.x, this.y, this.radius);
    }
}

package com.example.shanx.bouncingball;
import java.lang.Math;

/**
 * Created by Shanx on 3/10/2016.
 */
public class InnerSquare {

    int x, y;
    int a, b;
    final double sqrtOfTwo = 1.41421356237;
    int width, height;

    //constructor
    //p, q origin(x,y)
    //r radious
    public InnerSquare(int p, int q, int r)
    {
        width = (int) Math.abs(((2*r) / sqrtOfTwo));
        height = width;

        x = p;
        y = q;

        a = x+width;
        b = y+width;
    }

    //tells whether the given points are with in the area of sqaure
    // square (imaginary) inside the circle(bubble)
    public boolean DidHeTouchYou(int m, int n)
    {
        boolean retVal = false;
        if( ((m >= x) && (m <= a)) && ((n >= y) && (n <= b)))
        {
            retVal = true;
        }

        return retVal;
    }
}
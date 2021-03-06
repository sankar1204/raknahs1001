package com.example.shanx.bouncingball;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.DisplayMetrics;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Iterator;


/**
 * Created by Shanx on 2/20/2016.
 */
public class Layout extends View {

    //screen dimensions
    int screenWidth = 0;
    int screenHeight = 0;

    //position of first ball
    Point homePosition = new Point();

    //position for every next ball
    Point position = new Point();

    //number of balls present at the moment
    int bubbleCount = 0;

    //tells whether I can draw one moore ball
    boolean isSpaceThere = false;

    Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    Paint ballPaint = new Paint();
    Paint linkPaint = new Paint();
    Paint textPaint = new Paint();

    HashMap<Integer, Bubble> BubblesCollection = new HashMap<>();

    public final static String EXTRA_MESSAGE = "com.example.shanx.bouncingball.MESSAGE";

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            float currX = event.getX();
            float currY = event.getY();

            if(null == GetClickedBubble((int)currX, (int)currY))
            {
                return false;
            }

            //do your operations here
            Intent descriptionActivity = new Intent(this.getContext(), Information.class);
            //EditText infoText = (EditText) findViewById(R.id.information);
            String description  = " Hello India! things will change soon ";

            descriptionActivity.putExtra(EXTRA_MESSAGE, description);

            this.getContext().startActivity(descriptionActivity);
            invalidate();
        }
        return true;
    }



    //Returns Null if it doesn't find clicked bubble.
    private Bubble GetClickedBubble(int x, int y)
    {
        int key;
        Bubble clickedBubble = null;

        Iterator mapIterator = BubblesCollection.keySet().iterator();

        while(mapIterator.hasNext()) {
            key = (int) mapIterator.next();

            if(BubblesCollection.get(key).internalSquare.DidHeTouchYou(x,y) == true)
            {
                 clickedBubble = BubblesCollection.get(key);
            }
        }

        return clickedBubble ;
    }


    private boolean IsItOnBubble(float x, float y) {

        return false;
    }

    void GetScreenResolution()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
        homePosition.set(200, 300);
    }

    public Layout(Context context) {
        super(context);

        setBackgroundResource(R.drawable.background);
        setMinimumWidth(300);
        setMinimumHeight(300);
        GetScreenResolution();
    }

    ///Big boss
    public boolean drawCircle(Canvas c)
    {
        if(IsSpaceThere())
        {
            onDraw(c);
            return true;
        }
        else
        {
            //screen is full
            return false;
        }
    }

    private void WhereToDraw() {

        if(bubbleCount == 0) {
            position = homePosition;
        }
    }

    private boolean IsSpaceThere() {
        return true;
    }

    protected void onDraw(Canvas c)
    {
        super.onDraw(c);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);

        ballPaint.setColor(Color.GREEN);

        linkPaint.setColor(Color.RED);
        linkPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        linkPaint.setStrokeWidth(40);

        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(30);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        c.drawCircle(150, 150, 100, ballPaint);
        c.drawText("Step1", 150, 150, textPaint);
        path.moveTo(150, 250);
        path.lineTo(150, 350);
        path.close();
        c.drawPath(path, linkPaint);

        c.drawCircle(150, 450, 100, ballPaint);
        c.drawText("Step2", 150, 450, textPaint);
        path.moveTo(150, 550);
        path.lineTo(150, 650);
        path.close();
        c.drawPath(path, linkPaint);

        c.drawCircle(150, 750, 100, ballPaint);
        c.drawText("Step3", 150, 750, textPaint);
        path.moveTo(150, 850);
        path.lineTo(150, 950);
        path.close();
        c.drawPath(path,linkPaint);
    }

    private Bubble Draw(Canvas c)
    {
        super.onDraw(c);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);

        ballPaint.setColor(Color.YELLOW);

        linkPaint.setColor(Color.RED);
        linkPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        linkPaint.setStrokeWidth(40);

        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(10);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        c.drawCircle(150, 150, 100, ballPaint);
        c.drawText("Step1", 150, 150, textPaint);
        path.moveTo(150, 250);
        path.lineTo(150, 350);
        path.close();
        c.drawPath(path, linkPaint);

        c.drawCircle(150, 450, 100, ballPaint);
        c.drawText("Step2", 150, 450, textPaint);
        path.moveTo(150, 550);
        path.lineTo(150, 650);
        path.close();
        c.drawPath(path, linkPaint);

        c.drawCircle(150, 750, 100, ballPaint);
        c.drawText("Step3", 150, 750, textPaint);
        path.moveTo(150, 850);
        path.lineTo(150, 950);
        path.close();
        c.drawPath(path,linkPaint);

        return  new Bubble(position.x, position.y, 100);
    }

    //TODO: need to complete this,
    //basically this draws an arrow(fillable)
    // filling need to be done
    private Path CreatePath(float x, float y)
    {
        Path linkPath = new Path();
        linkPath.moveTo(x+200,y);//------>
        linkPath.moveTo(x,y-40);//------
        linkPath.moveTo(x+5,y+50);//------
        linkPath.moveTo(x-5,y+50);//------
        linkPath.moveTo(x, y - 40);//------
        linkPath.moveTo(x - 200, y);//<------
        linkPath.moveTo(x,y-10);


        //need to fill the arrow
        return linkPath;
    }
    private void DrawLink(Canvas c, Path path, Paint paint)
    {
        c.drawPath(path,paint);
    }




}

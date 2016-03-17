package com.example.shanx.bouncingball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(b);
    Layout ballView;
    public final static String EXTRA_MESSAGE = "com.example.shanx.bouncingball.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ballView = new Layout(this);
        setContentView(ballView);
        ballView.drawCircle(c);
    }

    //Initializes the apps home screen
    //based on his location, current time, and season and
    //many more deciding factors can be considered here.
    //Based on all those factors it asks / suggests things to user.
    private void Initialize() {

    }

    //Based on user selection get the content from
    // the server and draw the flowchart
    private void Preparation() {

    }


}

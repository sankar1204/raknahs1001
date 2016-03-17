package com.example.shanx.bouncingball;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent decriptionIntent = getIntent();
        String description = decriptionIntent.getStringExtra(Layout.EXTRA_MESSAGE);
        TextView descritionView = (TextView) findViewById(R.id.information);
        descritionView.setText(description);
    }

}

package com.thoughtworks.shikhargupta.eduindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String string = intent.getStringExtra("name");
//        TextView textView = new TextView();
//        textView.setText(string);

    }
}

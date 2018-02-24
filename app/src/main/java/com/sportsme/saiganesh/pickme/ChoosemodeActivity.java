package com.sportsme.saiganesh.pickme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoosemodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosemode);

    }

    public void signinFunction(View view)
    {

        SharedPreferences sharedPreferences=getSharedPreferences("PREFS",0);
        String count=sharedPreferences.getString("COUNT","");

        if (!count.equals("YES")) {

            Intent abc = new Intent(this, signup.class);
            startActivity(abc);
        }
        else {
            startActivity(new Intent(ChoosemodeActivity.this,LoginActivity.class));
        }
    }
}

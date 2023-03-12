package com.example.interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Main_menu extends AppCompatActivity implements View.OnClickListener {
    TextView name;
    Button simple, tough, other, rate, locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ConstraintLayout constraintLayout =findViewById(R.id.mainlauout);
        AnimationDrawable animationDrawable= (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        name=findViewById(R.id.namea);
        Intent a = getIntent();
        String str1 = a.getStringExtra("msg");
        name.setText(str1);

        simple = findViewById(R.id.simple);
        simple.setOnClickListener(this);

        tough = findViewById(R.id.tough);
        tough.setOnClickListener(this);

        other = findViewById(R.id.other);
        other.setOnClickListener(this);

        rate = findViewById(R.id.rate);
        rate.setOnClickListener(this);

        locations = findViewById(R.id.location);
        locations.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple:
                Intent s = new Intent(Main_menu.this,Simple.class);
                startActivity(s);
                break;

            case R.id.tough:
                startActivity(new Intent(Main_menu.this,Tough.class));
                break;

            case R.id.location:
                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://maps.app.goo.gl/6fZwMXxQLLuyVFGC7"));

                if (getIntent().resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"No App Available",Toast.LENGTH_LONG).show();
                }
                break;


                case R.id.rate:
                Intent r;
                r = new Intent(Intent.ACTION_VIEW);
                r.setData(Uri.parse("https://github.com/WASIQ16"));

                if (getIntent().resolveActivity(getPackageManager())!=null){
                    startActivity(r);
                }
                else {
                    Toast.makeText(getApplicationContext(),"No App Available",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.other:
                Intent o;
                o = new Intent(Intent.ACTION_VIEW);
                o.setData(Uri.parse("https://www.linkedin.com/in/mohammad-wasiq-zafar-a66a21233"));

                if (getIntent().resolveActivity(getPackageManager())!=null){
                    startActivity(o);
                }
                else {
                    Toast.makeText(getApplicationContext(),"No App Available",Toast.LENGTH_LONG).show();
                }
                break;

    }

    }
}
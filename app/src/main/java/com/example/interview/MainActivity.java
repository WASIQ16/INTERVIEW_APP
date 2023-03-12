package com.example.interview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  EditText nam;
  Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next=findViewById(R.id.next);
        nam=findViewById(R.id.name);

        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.next:
                Intent i=new Intent(MainActivity.this,Main_menu.class);
                i.putExtra("msg", nam.getText().toString());
                startActivity(i);

        }
    }
}
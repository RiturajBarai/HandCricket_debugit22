package com.example.handcricket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public  void openActivity(View view){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);

    }
    public  void openActivity2(View view){
        Intent intent=new Intent(this,MainActivity3.class);
        startActivity(intent);

    }
}
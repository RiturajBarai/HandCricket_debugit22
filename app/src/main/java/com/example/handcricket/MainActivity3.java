package com.example.handcricket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView userStat;
    TextView aiRun;
    Dialog dialog;
    int balls=0;
    int runsP1=0;
    int runsP2=0;
    int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userStat=findViewById(R.id.userStat);
        userStat.setText("You are bowling");
        t1=findViewById(R.id.p1score);
        t2=findViewById(R.id.p2score);
        aiRun=findViewById(R.id.aiRun);
        userStat=findViewById(R.id.userStat);
        dialog=new Dialog(this);


    }
    public void playAgain(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public int getRand(){
        int rand=new Random().nextInt(10) +1;
        if(rand>=1 && rand <=4)
            return 6;
        else if(rand>=5 && rand <=7)
            return 4;
        else if(rand >= 8 && rand <=9)
            return 2;
        else
            return 1;
    }
    public int getRand2(){
        int rand=new Random().nextInt(4) +1;
        if(rand==1)
            return 6;
        else if(rand==2)
            return 4;
        else if(rand==3)
            return 2;
        else
            return 1;
    }


    public void onClick1(View view){
       onClick(1);
    }
    public void onClick2(View view){
        onClick(2);
    }
    public void onClick4(View view){
       onClick(4);
    }
    public void onClick6(View view){
        onClick(6);
    }
    public void onClick(int k){
        int rand;
        if(flag==0)
            rand=getRand();
        else
            rand=getRand2();
        aiRun.setText(String.valueOf(rand));
        if(rand==k && flag==1){
            Toast.makeText(this, "BATTER OUT \nYOU ARE BATTING", Toast.LENGTH_SHORT).show();
            flag=0;
            userStat.setText("You are batting");
        }
        else if(rand==k && flag==0){
            Toast.makeText(this, "BATTER OUT YOU LOST", Toast.LENGTH_SHORT).show();
            dialog.setContentView(R.layout.you_loose);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }
        else if(flag==0){
            runsP1+=k;
            if(runsP1>runsP2){
                Toast.makeText(this, "TARGET REACHED YOU WON", Toast.LENGTH_SHORT).show();
                dialog.setContentView(R.layout.you_win);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
            t1.setText(String.valueOf(runsP1));
        }
        else if(flag==1){
            runsP2+=rand;
            t2.setText(String.valueOf(runsP2));
        }
    }

}
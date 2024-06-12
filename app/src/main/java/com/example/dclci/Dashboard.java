package com.example.dclci;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    private TextView text1,text2,text3,text4,text5,text6,text7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        text1 = (TextView) findViewById(R.id.text1Id);
        text2 = (TextView) findViewById(R.id.text2Id);
        text3 = (TextView) findViewById(R.id.text3Id);
        text4 = (TextView) findViewById(R.id.text4Id);
        text5 = (TextView) findViewById(R.id.text5Id);
        text6 = (TextView) findViewById(R.id.text6Id);
        text7 = (TextView) findViewById(R.id.text7Id);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        text4.setOnClickListener(this);
        text5.setOnClickListener(this);
        text6.setOnClickListener(this);
        text7.setOnClickListener(this);
    }
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Dashboard.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do You want to exit app?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if( v.getId()==R.id.text1Id)
        {
            Intent intent = new Intent(Dashboard.this,Bit_Stuffing.class);
            startActivity(intent);
        }
        else if( v.getId()==R.id.text2Id)
        {
            Intent intent = new Intent(Dashboard.this,Bit_Destuffing.class);
            startActivity(intent);
        }
        else if( v.getId()==R.id.text3Id)
        {
            Intent intent = new Intent(Dashboard.this,Character_Stuffing.class);
            startActivity(intent);
        }
        else if( v.getId()==R.id.text4Id)
        {
            Intent intent = new Intent(Dashboard.this,Character_Destuffing.class);
            startActivity(intent);
        }
        else if( v.getId()==R.id.text5Id)
        {
            Intent intent = new Intent(Dashboard.this, Generate_Parity.class);
            startActivity(intent);
        }
        else if( v.getId()==R.id.text6Id)
        {
            Intent intent = new Intent(Dashboard.this, Parity_Checker.class);
            startActivity(intent);
        }
        else if( v.getId()==R.id.text7Id)
        {
            Intent intent = new Intent(Dashboard.this, CRC_Generator.class);
            startActivity(intent);
        }
    }
}
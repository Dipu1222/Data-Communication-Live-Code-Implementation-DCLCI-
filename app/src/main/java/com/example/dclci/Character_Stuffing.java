package com.example.dclci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Character_Stuffing extends AppCompatActivity implements View.OnClickListener {

    private Button user_define,Default;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stuffing);
        user_define = (Button) findViewById(R.id.userdefine_butonid);
        Default = (Button) findViewById(R.id.default_butonid);
        user_define.setOnClickListener(this);
        Default.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.userdefine_butonid)
        {
            Intent intent = new Intent(Character_Stuffing.this,User_define.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.default_butonid)
        {
            Intent intent = new Intent(Character_Stuffing.this,Default_input.class);
            startActivity(intent);
        }

    }
}
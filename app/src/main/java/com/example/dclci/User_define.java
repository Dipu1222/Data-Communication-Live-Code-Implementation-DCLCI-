package com.example.dclci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class User_define extends AppCompatActivity implements View.OnClickListener {

    private EditText enter_flag,enter_massage,enter_escape;
    private Button submit_button;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_define);

        enter_flag = (EditText) findViewById(R.id.enter_flagid);
        enter_massage = (EditText) findViewById(R.id.enter_massageid);
        enter_escape = (EditText) findViewById(R.id.enter_escapeid);
        submit_button = (Button) findViewById(R.id.characterstuffing_buttonid);
        result = (TextView) findViewById(R.id.result_id);
        submit_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.characterstuffing_buttonid)
        {
            String flag = enter_flag.getText().toString();
            String massage = enter_massage.getText().toString();
            String escape = enter_escape.getText().toString();
            if(flag.isEmpty() || massage.isEmpty() || escape.isEmpty())
            {
                Toast.makeText(this, "Enter all field", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String res = new String();
                String out=new String();
                int i,j;
                for(i=0,j=0;i<massage.length();i++)
                {
                    if(massage.charAt(i) == escape.charAt(j))
                    {

                        res = res + massage.charAt(i);
                        res = res + escape;
                    }
                    else
                    {
                        res = res + massage.charAt(i);

                    }

                }
                result.setText(flag+res+flag);
            }
        }
    }
}
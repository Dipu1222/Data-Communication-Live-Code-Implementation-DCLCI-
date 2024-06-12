package com.example.dclci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Generate_Parity extends AppCompatActivity implements View.OnClickListener {
    private Button parity_button;
    private EditText bit;
    private TextView result;
    private RadioGroup radiogroup;
    private RadioButton radioButton;
    private RadioButton evenbutton,oddbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_parity);
        parity_button = (Button) findViewById(R.id.parity_buttonid);
        bit = (EditText) findViewById(R.id.enter_paritybitid);
        result = (TextView) findViewById(R.id.result_id);
        radiogroup = (RadioGroup) findViewById(R.id.radio);
        evenbutton = (RadioButton)findViewById(R.id.even);
        oddbutton = (RadioButton)findViewById(R.id.odd);
        parity_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.parity_buttonid)
        {
            String data = bit.getText().toString();
            int k=0,cheker=0,n=0;
            for(k=0;k<data.length();k++)
            {
                if(data.charAt(k)!='0' && data.charAt(k)!='1')
                {
                    n=-1;
                    break;
                }
                if(data.charAt(k)=='0')
                {
                    cheker++;
                }
            }
            if(data.isEmpty() || (!evenbutton.isChecked() && !oddbutton.isChecked()))
            {
                Toast.makeText(this, "Enter all field", Toast.LENGTH_SHORT).show();
            }
            else if(n==-1)
            {
                result.setText("Enter only 0 or 1");
            }
            else if(cheker==data.length())
            {
                result.setText("Enter valid data");
            }
            else
            {
                if(evenbutton.isChecked())
            {
                int i,counter=0;
                    for(i=0;i<data.length();i++)
                    {
                        if(data.charAt(i)=='1')
                        {
                            counter++;
                        }
                    }
                    if(counter%2==0)
                    {
                        result.setText(0+data);
                    }
                    else
                    {
                        result.setText(1+data);
                    }
            }
            else if(oddbutton.isChecked())
            {
                int i,counter=0;

                    for(i=0;i<data.length();i++)
                    {
                        if(data.charAt(i)=='1')
                        {
                            counter++;
                        }
                    }
                    if(counter%2==0)
                    {
                        result.setText(1+data);
                    }
                    else
                    {
                        result.setText(0+data);
                    }
            }
            }




        }
    }
}
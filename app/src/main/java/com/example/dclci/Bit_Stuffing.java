package com.example.dclci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bit_Stuffing extends AppCompatActivity implements View.OnClickListener{

    private Button stuffing_button;
    private EditText bit;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_stuffing);

        stuffing_button = (Button) findViewById(R.id.bitstuffing_buttonid);
        bit = (EditText) findViewById(R.id.enterbit_bitstuffingid);
        result = (TextView) findViewById(R.id.result_id);
        stuffing_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bitstuffing_buttonid)
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
            if(data.isEmpty())
            {
                Toast.makeText(this, "Enter bit", Toast.LENGTH_SHORT).show();
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
                String res = new String();
                int counter = 0,i;
                    for(i=0;i<data.length();i++)
                    {
                        if(data.charAt(i) == '1')
                        {
                            counter++;
                            res = res + data.charAt(i);
                        }
                        else
                        {
                            res = res + data.charAt(i);
                            counter = 0;
                        }
                        if(counter == 5)
                        {
                            res = res + '0';
                            counter = 0;
                        }
                    }
                    result.setText(res);
            }

        }

    }
}
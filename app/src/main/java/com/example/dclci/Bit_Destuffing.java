package com.example.dclci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bit_Destuffing extends AppCompatActivity implements View.OnClickListener {

    private Button destuffing_button;
    private EditText bit;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_destuffing);
        destuffing_button = (Button) findViewById(R.id.bitdestuffing_buttonid);
        bit = (EditText) findViewById(R.id.enterbit_destuffingid);
        result = (TextView) findViewById(R.id.result_id);
        destuffing_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.bitdestuffing_buttonid)
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
                if(data.length()==5)
                {
                    result.setText(data);
                }
                else
                {
                    String out=new String();
                    int counter=0,i;
                        for(i=0;i<data.length();i++)
                        {
                            if(data.charAt(i) == '1')
                            {
                                counter++;
                                out = out + data.charAt(i);
                            }
                            else
                            {
                                out = out + data.charAt(i);
                                counter = 0;
                            }
                            if(counter == 5)
                            {
                                if((i+2)!=data.length())
                                    out = out + data.charAt(i+2);
                                else
                                    out=out + '1';
                                i=i+2;
                                counter = 1;
                            }
                        }
                        result.setText(out);
                }

            }

        }

    }
}
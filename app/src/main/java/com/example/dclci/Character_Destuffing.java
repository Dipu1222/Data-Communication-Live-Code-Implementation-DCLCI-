package com.example.dclci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Character_Destuffing extends AppCompatActivity implements View.OnClickListener {

    private EditText enter_flag,enter_massage;
    private Button submit_button;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_destuffing);

        enter_flag = (EditText) findViewById(R.id.enter_flagid);
        enter_massage = (EditText) findViewById(R.id.enter_massageid);
        submit_button = (Button) findViewById(R.id.characterstuffing_buttonid);

        result = (TextView) findViewById(R.id.result_id);
        submit_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.characterstuffing_buttonid)
        {
            String flag = enter_flag.getText().toString();
            String data = enter_massage.getText().toString();
            if(flag.isEmpty() || data.isEmpty() )
            {
                Toast.makeText(this, "Enter all field", Toast.LENGTH_SHORT).show();
            }
            else
            {
                int i = 0, j ;
                char[] d = new char[100];
                String massage = flag+data+flag;
                j = flag.length();
                while (j < massage.length()-flag.length() && massage.charAt(j)!= '\0') {
                    if (massage.charAt(j) == 'D' && massage.charAt(j+1) == 'L' && massage.charAt(j+2) == 'E' &&
                            massage.charAt(j+3) == 'D' && massage.charAt(j+4) == 'L' && massage.charAt(j+5) == 'E') {
                        d[i] = 'D'; d[i + 1] = 'L'; d[i + 2] = 'E';
                        j += 6;
                        i += 3;
                    } else {
                        d[i++] = massage.charAt(j++);
                    }
                }
                d[i] = '\0';
                String stuffedData = new String(d);
                result.setText(stuffedData);

            }
        }

    }
}
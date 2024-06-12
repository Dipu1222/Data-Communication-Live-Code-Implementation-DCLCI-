package com.example.dclci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Default_input extends AppCompatActivity implements View.OnClickListener {

    private EditText enter_flag,enter_massage;
    private Button submit_button;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_input);

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
            String massage = enter_massage.getText().toString();
            if(flag.isEmpty() || massage.isEmpty() )
            {
                Toast.makeText(this, "Enter all field", Toast.LENGTH_SHORT).show();
            }
            else
            {
                 int i = 0, j = 6;
                char[] sd = new char[100];

                while (i < massage.length()) {
                    if (massage.charAt(i) == 'D' && i + 2 < massage.length() && massage.charAt(i+1) == 'L' && massage.charAt(i+2) == 'E') {
                        sd[j] = 'D'; sd[j + 1] = 'L'; sd[j + 2] = 'E'; sd[j + 3] = 'D';
                        sd[j + 4] = 'L'; sd[j + 5] = 'E';
                        j += 6;
                        i += 3;
                    } else {
                        sd[j++] = massage.charAt(i++);
                    }
                }
                sd[j] = '\0';
                String stuffedData = new String(sd);

                result.setText(flag+stuffedData+flag);


            }
        }

    }
}
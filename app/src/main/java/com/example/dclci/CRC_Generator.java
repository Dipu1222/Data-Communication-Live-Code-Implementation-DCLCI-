package com.example.dclci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class CRC_Generator extends AppCompatActivity implements View.OnClickListener {
    private Button crc_button;
    private EditText input1, input2;
    private TextView result;
    static int n, devlen, len;
    static char[] temp = new char[20];
    static char[] total = new char[100];
    static char[] bit, divisor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crc_generator);
        crc_button = (Button) findViewById(R.id.crc_buttonid);
        input1 = (EditText) findViewById(R.id.enter_bitid);
        input2 = (EditText) findViewById(R.id.enter_divisorid);
        result = (TextView) findViewById(R.id.result_id);
        crc_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.crc_buttonid) {
            String bitString = input1.getText().toString();
            String divisorString = input2.getText().toString();

            if (bitString.isEmpty() || divisorString.isEmpty()) {
                Toast.makeText(this, "Enter both bit and divisor", Toast.LENGTH_SHORT).show();
                return;
            }

            bit = bitString.toCharArray();
            divisor = divisorString.toCharArray();

            int cheker = 0;
            int p = 0, m = 0;

            for (char c : bit) {
                if (c != '0' && c != '1') {
                    p = -1;
                    break;
                }
                if (c == '0') {
                    cheker++;
                }
            }

            for (char c : divisor) {
                if (c != '0' && c != '1') {
                    m = -1;
                    break;
                }
            }

            if (p == -1 || m == -1) {
                result.setText("Enter only 0 or 1 ");
                return;
            }

            if (cheker == bit.length) {
                result.setText("Enter valid bit data");
                return;
            }

            cheker = 0;  // Reset checker for divisor
            for (char c : divisor) {
                if (c == '0') {
                    cheker++;
                }
            }

            if (cheker == divisor.length) {
                result.setText("Enter valid divisor data");
                return;
            }

            n = bit.length;
            devlen = divisor.length;
            len = n + devlen - 1;

            System.arraycopy(bit, 0, total, 0, n);

            for (int i = n; i < len; i++) {
                total[i] = '0';
            }

            checkData();

            result.setText(String.valueOf(temp, 0, n + devlen - 1));
        }
    }

    static void checkData() {
        int j;
        for (j = 0; j < devlen; j++) {
            temp[j] = total[j];
        }

        while (j <= len) {
            if (temp[0] == '1') {
                for (int i = 1; i < devlen; i++) {
                    temp[i] = (temp[i] == divisor[i]) ? '0' : '1';
                }
            }
            System.arraycopy(temp, 1, temp, 0, devlen - 1);

            if (j < len) {
                temp[devlen - 1] = total[j];
            }
            j++;
        }
    }


}
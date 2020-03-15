package com.example.se2_single;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // in range 0-9; prime: if >1 and dividable only by itself and 1
    // needed for studentId % 7 = 4
    private static final int[] primeDigits = {2, 3, 5, 7};

    private EditText et_id = null;
    private Button btn_server = null;
    private Button btn_local = null;
    private TextView tv_result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.et_id = findViewById(R.id.editText_studentId);
        this.btn_server = findViewById(R.id.button_serverRequest);
        this.btn_local = findViewById(R.id.button_localCalc);
        this.tv_result = findViewById(R.id.textView_result);
    }

    public void onClickBtnLocalCalc(View view) {
        Log.d("TAG", "onClickBtnLocalCalc: clicked local calc");

        String primes = extractPrimes(et_id.getText().toString());
        tv_result.setText(primes);
    }

    public void onClickBtnSendRequest(View view) {

    }


    private static String extractPrimes(String student_id) {
        String res = "";

        char[] chars = student_id.toCharArray();
        for (char c: chars) {
            int i = Character.getNumericValue(c);
            for (int prime: primeDigits) {
                if (i == prime)
                    res += i;
            }
        }
        return res;
    }
}

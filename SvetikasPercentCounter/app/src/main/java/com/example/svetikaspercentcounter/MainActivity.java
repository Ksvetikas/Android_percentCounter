package com.example.svetikaspercentcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        TextView tip = findViewById(R.id.textView2);
        TextView total = findViewById(R.id.textView3);
        TextView result = findViewById(R.id.textView4);
        TextView progress = findViewById(R.id.percentProgress);
        SeekBar seekBar = findViewById(R.id.seekBar);
        EditText editText = (EditText)findViewById(R.id.editText);


        result.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress.setText(i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {

                    String field = editText.getText().toString();
                    double value = Double.parseDouble(field);

                    int seekBarValue = seekBar.getProgress();

                    if (!"".equals(field) && value > 0){

                        double tipValue = Counter.tip(value, seekBarValue);
                        double totalValue = (value - tipValue);

                        tip.setText(String.valueOf(tipValue));
                        total.setText(String.valueOf(totalValue));

                        result.setGravity(Gravity.START | Gravity.TOP);
                        result.setText(Counter.result(field, tipValue, totalValue));

                    }else {
                        editText.setText("");
                        tip.setText("");
                        total.setText("");
                        result.setText("");
                        result.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                    }
                }
                return false;
            }
        });
    }
}
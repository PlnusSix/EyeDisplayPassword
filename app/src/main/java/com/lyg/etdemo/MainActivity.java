package com.lyg.etdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText mTestET;
    private TextView mTestTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestET = (EditText) this.findViewById(R.id.testET);
        mTestTV = (TextView) this.findViewById(R.id.testTV);

        mTestTV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mTestET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        moveCursorToEnd(mTestET);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "onTouch: 手指移动");
                        break;
                    case MotionEvent.ACTION_UP:
                        mTestET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        moveCursorToEnd(mTestET);
                        break;
                }
                return true;
            }
        });
    }

    public void moveCursorToEnd(EditText editText) {
        CharSequence charSequence = editText.getText();
        if (charSequence instanceof Spannable) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }
}

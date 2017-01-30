package com.fox1q.scoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int leftScore = 0;
    private int rightScore = 0;

    TextView leftScoreView;
    TextView rightScoreView;

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftScoreView = (TextView) findViewById(R.id.left_score);
        rightScoreView = (TextView) findViewById(R.id.right_score);

        addOnClickLeft();
        addOnClickRight();
    }

    public void addOnClickLeft() {
        imageButton = (ImageButton) findViewById(R.id.left_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftScoreView.setText(String.valueOf(++leftScore));
            }
        });
    }

    public void addOnClickRight() {
        imageButton = (ImageButton) findViewById(R.id.right_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightScoreView.setText(String.valueOf(++rightScore));
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("leftScore", leftScore);
        outState.putInt("rightScore", rightScore);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        leftScore = savedInstanceState.getInt("leftScore");
        rightScore = savedInstanceState.getInt("rightScore");
        leftScoreView.setText(String.valueOf(leftScore));
        rightScoreView.setText(String.valueOf(rightScore));
    }

    public void OnClickReset(View view) {
        leftScore = 0;
        rightScore = 0;
        leftScoreView.setText(String.valueOf(leftScore));
        rightScoreView.setText(String.valueOf(rightScore));
    }
}
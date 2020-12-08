package com.example.textquest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Game game;

    private LinearLayout linearLayout;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game(this);

        linearLayout = findViewById(R.id.linear);
        textView = findViewById(R.id.text);

        showLocation(game.getCurLocation());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        Location location = game.getChoice((Integer) v.getTag(R.id.action));
        showLocation(location);
    }

    private void showLocation(Location location) {
        linearLayout.removeAllViews();

        Action[] actions = location.actions;

        textView.setText(location.text);
        for (int i = 0; i < actions.length; i++) {
            Button button = new Button(this);
            button.setText(actions[i].text);

            button.setBackgroundColor(Color.rgb(0, 255, 142));
            button.setTextSize(30);
            button.setTextColor(Color.rgb(0, 0, 0));

            button.setTag(R.id.action, i);
            button.setOnClickListener(this);
//            button.setBackgroundResource(R.drawable.button_action);
            linearLayout.addView(button);
        }
    }
}
package com.example.sebastianuchwat.thehub.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.sebastianuchwat.thehub.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.card_view_weather) CardView mOpenWeather;

    public static final String EXTRA_MESSAGE = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mOpenWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplayWeatherActivity.class);
                startActivity(intent);
            }
        });

    }

    /** Called when the user taps the Send button */
    public void renderWeatherActivity(View view) {
        Intent intent = new Intent(this, DisplayWeatherActivity.class);
        //EditText editText = findViewById(R.id.editText2);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

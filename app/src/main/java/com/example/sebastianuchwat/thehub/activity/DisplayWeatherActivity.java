package com.example.sebastianuchwat.thehub.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.sebastianuchwat.thehub.R;
import com.example.sebastianuchwat.thehub.fragment.WeatherDetailFragment;
import com.example.sebastianuchwat.thehub.fragment.WeatherListFragment;
import com.example.sebastianuchwat.thehub.viewholder.WeatherRowViewHolder;

public class DisplayWeatherActivity extends AppCompatActivity implements WeatherListFragment.OnDaySelectedListener {

    private WeatherRowViewHolder mWeatherRowViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);

        /* Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        */

        // CHeck if layout has fragment container
        if (findViewById(R.id.fragment_container) != null) {

            // Don't do anything if being restored from previous state to avoid overlapping fragments
            if (savedInstanceState != null) {
                return;
            }

            // Create new fragment to be placed in activity layout
            WeatherListFragment weatherListFragment = new WeatherListFragment();

            //In case this activity was started with special instructions from Intent, pass the Intent's extras to the fragment as arguments
            weatherListFragment.setArguments(getIntent().getExtras());

            //Add fragment to the container
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, weatherListFragment).commit();

        }
    }

    public void openWeatherDetailFragment(View view) {
        WeatherDetailFragment weatherDetailFragment = new WeatherDetailFragment();
        Bundle args = new Bundle();
        //args.putInt(WeatherDetailFragment.ARG_POSITION, position);
        weatherDetailFragment.setArguments(args);

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the container with this fragment and add the transaction to the back stack so
        // user can navigate back
        fragmentTransaction.replace(R.id.fragment_container, weatherDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onDaySelected(int position, String text) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();

        WeatherDetailFragment weatherDetailFragment = new WeatherDetailFragment();
        Bundle args = new Bundle();
        //args.putInt(WeatherDetailFragment.ARG_POSITION, position);
        weatherDetailFragment.setArguments(args);
        weatherDetailFragment.setFirstLine(text);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).show(weatherDetailFragment);

        fragmentTransaction.replace(R.id.fragment_container, weatherDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

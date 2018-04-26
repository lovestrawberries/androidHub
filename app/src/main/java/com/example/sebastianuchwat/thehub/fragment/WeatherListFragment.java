package com.example.sebastianuchwat.thehub.fragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastianuchwat.thehub.R;
import com.example.sebastianuchwat.thehub.contract.RecyclerViewClickListener;
import com.example.sebastianuchwat.thehub.model.WeatherDayModel;
import com.example.sebastianuchwat.thehub.adapter.WeatherListAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class WeatherListFragment extends Fragment {

    //Instancja interfejsu przez ktora mozna zrobic call do metody interfejsu
    OnDaySelectedListener mCallback;

    // Aktywnosc rodzic musi implementowac ten interfejs
    public interface OnDaySelectedListener {
        void onDaySelected(int position, String weather);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Check to make sure container activity implemented the callback interface
        try {
            mCallback = (OnDaySelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnDaySelectedListener");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_weather_list, container, false);

        WeatherDayModel monday = new WeatherDayModel("Monday", "Sunny", "clear_day");
        WeatherDayModel tuesday = new WeatherDayModel("Tuesday", "Cloudy", "cloudy");
        WeatherDayModel wednesday = new WeatherDayModel("Wednesday", "Partly Cloudy", "partly_cloudy_day");

        WeatherDayModel[] values = new WeatherDayModel[]{monday, tuesday, wednesday};

        final ArrayList<WeatherDayModel> weatherDays = new ArrayList<>();
        weatherDays.addAll(Arrays.asList(values));

        RecyclerViewClickListener recyclerViewClickListener = (v, position) -> {
            //Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();

            // TODO
            mCallback.onDaySelected(position, "cokolwiek");

        };

        WeatherListAdapter adapter = new WeatherListAdapter(recyclerViewClickListener);
        adapter.updateData(weatherDays);

        RecyclerView recyclerView = view.findViewById(R.id.weather_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}

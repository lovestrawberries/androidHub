package com.example.sebastianuchwat.thehub.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sebastianuchwat.thehub.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sebastianuchwat on 29/01/2018e.
 */

public class WeatherDetailFragment extends Fragment {

    @BindView(R.id.line_one) TextView firstLine;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {

        View view = layoutInflater.inflate(R.layout.fragment_weather_detail, container, false);

        ButterKnife.bind(getActivity());



        return view;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine.setText(firstLine);
    }
}

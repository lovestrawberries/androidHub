package com.example.sebastianuchwat.thehub.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastianuchwat.thehub.R;
import com.example.sebastianuchwat.thehub.contract.RecyclerViewClickListener;
import com.example.sebastianuchwat.thehub.model.WeatherDayModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sebastianuchwat on 12/02/2018.
 */

public class WeatherRowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mFirstLine;
    private TextView mSecondLine;
    private ImageView mIcon;
    private Map<String, Integer> mIconMap = new HashMap<>();
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public WeatherRowViewHolder(View itemView, RecyclerViewClickListener listener) {
        super(itemView);

        mIconMap.put("clear_day", R.drawable.clear_day);
        mIconMap.put("cloudy", R.drawable.cloudy);
        mIconMap.put("partly_cloudy_day", R.drawable.partly_cloudy_day);

        mFirstLine = itemView.findViewById(R.id.first_line);
        mSecondLine = itemView.findViewById(R.id.second_line);
        mIcon = itemView.findViewById(R.id.weatherIcon);

        mRecyclerViewClickListener = listener;
        itemView.setOnClickListener(this);

    }

    public void bindData(WeatherDayModel weatherDayModel) {
        mFirstLine.setText(weatherDayModel.getmDay());
        mSecondLine.setText(weatherDayModel.getmWeatherShort());
        mIcon.setImageResource(mIconMap.get(weatherDayModel.getmIcon()));

    }

    @Override
    public void onClick(View view) {
        //int position = getLayoutPosition();
        //Toast.makeText(view.getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();

        // Interface to transmit data to WeatherListFragment
        mRecyclerViewClickListener.onClick(view, getAdapterPosition());
    }
}

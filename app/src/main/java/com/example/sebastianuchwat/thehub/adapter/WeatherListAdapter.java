package com.example.sebastianuchwat.thehub.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastianuchwat.thehub.R;
import com.example.sebastianuchwat.thehub.contract.RecyclerViewClickListener;
import com.example.sebastianuchwat.thehub.model.WeatherDayModel;
import com.example.sebastianuchwat.thehub.viewholder.WeatherRowViewHolder;

import java.util.ArrayList;
import java.util.List;

public class WeatherListAdapter extends RecyclerView.Adapter {

    private RecyclerViewClickListener mListener;
    private List<WeatherDayModel> list = new ArrayList<>();

    public WeatherListAdapter(RecyclerViewClickListener recyclerViewClickListener) {
            mListener = recyclerViewClickListener;
    }

    public void updateData(List<WeatherDayModel> dataset) {
        list.clear();
        list.addAll(dataset);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new WeatherRowViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((WeatherRowViewHolder) holder).bindData(list.get(position));
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.row_weather_day;
    }




    /*
    HashMap<WeatherDayModel, Integer> myMap = new HashMap<>();

    public WeatherListAdapter(Context context, ArrayList<WeatherDayModel> objects) {
        super(context, -1, objects);
        this.objects = objects;

        for (int i = 0; i < objects.size(); i++) {
            myMap.put(objects.get(i), i);
        }
    }
    */

    /*
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.row_weather_day, parent, false);

        TextView firstLine = view.findViewById(R.id.first_line);
        TextView secondLine = view.findViewById(R.id.second_line);

        firstLine.setText(objects.get(position).getmDay());
        secondLine.setText(objects.get(position).getmWeatherShort());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListView) parent).performItemClick(view, position, 0);
            }
        });

        return view;
    }
    */
}

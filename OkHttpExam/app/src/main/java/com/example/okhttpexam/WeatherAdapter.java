package com.example.okhttpexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {

    List<Weather> weatherList = new ArrayList<>();

    public WeatherAdapter(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_weather_item, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CustomViewHolder cHolder = (CustomViewHolder) holder;

        cHolder.country_tv.setText(weatherList.get(position).getCountry());
        cHolder.weather_tv.setText(weatherList.get(position).getWeather());
        cHolder.temp_tv.setText(weatherList.get(position).getTemp());
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView country_tv, weather_tv, temp_tv;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            country_tv = itemView.findViewById(R.id.country_tv);
            weather_tv = itemView.findViewById(R.id.weather_tv);
            temp_tv = itemView.findViewById(R.id.temp_tv);

        }
    }
}

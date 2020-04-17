package com.example.learn_smartcultureappcontent;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    ArrayList<Weather> dataList;

    public WeatherAdapter(ArrayList<Weather> list) {
        this.dataList = list;
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_weather, parent, false);

            ImageView imageView = convertView.findViewById(R.id.imageview);
            TextView city_tv = convertView.findViewById(R.id.city_tv);
            TextView temp_tv = convertView.findViewById(R.id.temp_tv);

            holder.imageView = imageView;
            holder.city_tv = city_tv;
            holder.temp_tv = temp_tv;

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Weather weather = dataList.get(position);
        // holder.imageView.setImageResource(weather.getWeather());
        return null;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView city_tv;
        TextView temp_tv;
    }
}

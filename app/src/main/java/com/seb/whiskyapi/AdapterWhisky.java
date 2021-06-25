package com.seb.whiskyapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.seb.whiskyapi.models.Whisky;

import java.util.List;

public class AdapterWhisky extends BaseAdapter {
    protected Activity activity;
    protected List<Whisky> listWhisky;

    public AdapterWhisky(Activity activity, List<Whisky> listWhisky) {
        this.activity = activity;
        this.listWhisky = listWhisky;
    }

    @Override
    public int getCount() {
        return listWhisky.size();
    }

    @Override
    public Object getItem(int position) {
        return listWhisky.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.listado_whisky,null);
        }

        Whisky whisky = listWhisky.get(position);
        TextView nameWhisky = v.findViewById(R.id.tvName);
        nameWhisky.setText(whisky.getTvName());

        TextView slug = v.findViewById(R.id.tvSlug);
        slug.setText(whisky.getTvSlug());

        TextView baseWhisky = v.findViewById(R.id.tvMoneda);
        baseWhisky.setText(whisky.getTvMoneda());
        return v;
    }
}

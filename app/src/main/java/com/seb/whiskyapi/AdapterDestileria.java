package com.seb.whiskyapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.seb.whiskyapi.models.Destileria;
import com.seb.whiskyapi.models.Whisky;

import java.util.List;

public class AdapterDestileria extends BaseAdapter {
    protected Activity activity;
    protected List<Destileria> listDestileria;

    public AdapterDestileria(Activity activity, List<Destileria> listDestileria) {
        this.activity = activity;
        this.listDestileria = listDestileria;
    }

    @Override
    public int getCount() {
        return listDestileria.size();
    }

    @Override
    public Object getItem(int position) {
        return listDestileria.get(position);
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
            v = inf.inflate(R.layout.listado_destileria,null);
        }

        Destileria destileria = listDestileria.get(position);
        TextView nameDestileria = v.findViewById(R.id.tvNameDesti);
        nameDestileria.setText(destileria.getTvNameDesti());

        TextView slug = v.findViewById(R.id.tvSlugDesti);
        slug.setText(destileria.getTvSlugDesti());

        TextView baseWhisky = v.findViewById(R.id.tvPaisDesti);
        baseWhisky.setText(destileria.getTvPaisDesti());
        return v;
    }
}

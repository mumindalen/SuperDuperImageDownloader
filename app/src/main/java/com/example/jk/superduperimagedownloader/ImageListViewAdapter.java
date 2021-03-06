package com.example.jk.superduperimagedownloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jk on 2017-02-01.
 */

public class ImageListViewAdapter extends ArrayAdapter<String> {

    private Context context;
    private LayoutInflater inflater;

    private ViewHolder holder;

    public ImageListViewAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            boolean attachToRoot = false;
            convertView = inflater.inflate(R.layout.single_image_item_layout, parent, attachToRoot);

            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String url = getItem(position);

        Picasso
                .with(context)
                .load(url)
                .centerCrop()
                .resizeDimen(R.dimen.activity_image_width, R.dimen.activity_image_height)
                .into(holder.imageView);

        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
    }
}

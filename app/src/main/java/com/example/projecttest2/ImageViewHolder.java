package com.example.projecttest2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    static View mView;


    public ImageViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
    }


    public  void setImages(String image , String name) {
        TextView tx = mView.findViewById(R.id.name);
        tx.setText(name);

        ImageView mv = mView.findViewById(R.id.Image_ret);
        Picasso.get().load(image).into(mv);
    }

    public void setdetail(String image, String name, String water, String sun, String loc) {

        TextView txname = mView.findViewById(R.id.plantname);
        txname.setText(name);

        TextView txwater = mView.findViewById(R.id.watertx);
        txwater.setText(water);

        TextView txsun = mView.findViewById(R.id.suntx);
        txsun.setText(sun);

        TextView txloc = mView.findViewById(R.id.loctx);
        txloc.setText(loc);

        ImageView mv = mView.findViewById(R.id.Image_ret);
        Picasso.get().load(image).into(mv);

    }


}
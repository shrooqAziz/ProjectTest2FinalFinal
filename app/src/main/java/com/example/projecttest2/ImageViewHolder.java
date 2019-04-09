package com.example.projecttest2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageViewHolder extends RecyclerView.ViewHolder{
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

}
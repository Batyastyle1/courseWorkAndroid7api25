package com.example.courseworkandroid7api25.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.courseworkandroid7api25.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class GridImageAdapter extends ArrayAdapter<String>{
    private Context context;
    private LayoutInflater inflater;
    private int layoutResource;
    private String append;
    private ArrayList<String> imgURLs;


    public GridImageAdapter(Context context,   int layoutResource, String append, ArrayList<String> imgURLs) {
        super(context,layoutResource,imgURLs);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;

        this.layoutResource = layoutResource;
        this.append = append;
        this.imgURLs = imgURLs;
    }



    private static class ViewHolder{
        SquareImageView profileImage;
        ProgressBar progressBar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        //viewHolder imitiruet recyclerView

        if (convertView == null){
            convertView=inflater.inflate(layoutResource,parent, false);
            viewHolder = new ViewHolder();
            viewHolder.progressBar=(ProgressBar) convertView.findViewById(R.id.grid_image_view_progressbar);
            viewHolder.profileImage=(SquareImageView) convertView.findViewById(R.id.grid_image_view);

            convertView.setTag(viewHolder);


        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        String imgURL = getItem(position);

        ImageLoader imageLoader =ImageLoader.getInstance();

        imageLoader.displayImage(append + imgURL, viewHolder.profileImage, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (viewHolder.progressBar != null){
                    viewHolder.progressBar.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (viewHolder.progressBar != null){
                    viewHolder.progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (viewHolder.progressBar != null){
                    viewHolder.progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (viewHolder.progressBar != null){
                    viewHolder.progressBar.setVisibility(View.GONE);

                }
            }
        });

        return convertView;
    }
}

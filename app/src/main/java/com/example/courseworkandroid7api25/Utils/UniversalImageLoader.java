package com.example.courseworkandroid7api25.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.courseworkandroid7api25.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class UniversalImageLoader {

    private static final int defaultImage = R.drawable.ic_android;
    private Context mContext;

    public UniversalImageLoader(Context context){
        mContext = context;
    }
    public ImageLoaderConfiguration getConfig(){
        DisplayImageOptions defaultOptions= new DisplayImageOptions.Builder().showImageOnLoading(defaultImage)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration configuration  = new ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100*1024*1024).build();
        return configuration;

    }

    //this method  can be used to set images that  are static.It can't be used if the images are being changed in the Fragment/Activity
    // or if they are being set in alist or in a grid

//    этот метод можно использовать для установки статических изображений. Его нельзя использовать, если изображения изменяются во фрагменте/activity.
    // или если они устанавливаются в списке или в сетке

    public static void setImage(String imgUrl, ImageView image, final ProgressBar progressBar, String append){
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(append + imgUrl, image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (progressBar != null){
                    progressBar.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (progressBar != null){
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (progressBar != null){
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (progressBar != null){
                    progressBar.setVisibility(View.GONE);

                }
            }
        });


    }

}

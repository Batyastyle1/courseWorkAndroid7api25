package com.example.courseworkandroid7api25.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.courseworkandroid7api25.R;
import com.example.courseworkandroid7api25.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment {
    private static final String TAG = "EditProfileFragment";
    private ImageView profilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile,container,false);
        profilePhoto=(ImageView) view.findViewById(R.id.profile_photo);

        setProfileImage();

        //nazad v profile Fragment
        ImageView backArrow = (ImageView) view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: nazad profile activity");
                getActivity().finish();
            }
        });

        return view;


    }



    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile image.");
         String imgURL ="play-lh.googleusercontent.com/_lOb03KA0dC0e7ytxmGqfk3wsUjf9GFPkkuqiwDzLEBoGjUBUn3vqOHI0wh9NKFF06JL=w600-h300-pc0xffffff-pd";
        UniversalImageLoader.setImage(imgURL,profilePhoto,null,"https://");
    }
}

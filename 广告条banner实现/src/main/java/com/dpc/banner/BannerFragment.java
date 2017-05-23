package com.dpc.banner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class BannerFragment extends Fragment {

    private int imgId;

    public BannerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflater1=inflater.inflate(R.layout.fragment_banner, container, false);
        ImageView imageView=(ImageView) inflater1.findViewById(R.id.iv_banner);
        imageView.setImageResource(imgId);
        return inflater1;
    }

    public void setImg(int imgId){
        this.imgId=imgId;
    }

}

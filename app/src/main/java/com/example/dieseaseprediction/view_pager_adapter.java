package com.example.dieseaseprediction;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.io.OptionalDataException;


public class view_pager_adapter extends PagerAdapter {

    public OptionalDataException sliderImageId1;
    Context mcontext;
    public view_pager_adapter(Context context){
        this.mcontext=context;
    }
    @Override
    public int getCount() {
        return sliderImageId.length;
    }

    int[] sliderImageId = new int[]{
            R.drawable.v1, R.drawable.v2, R.drawable.v5,R.drawable.v4,
    };

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView) object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(sliderImageId[position]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}